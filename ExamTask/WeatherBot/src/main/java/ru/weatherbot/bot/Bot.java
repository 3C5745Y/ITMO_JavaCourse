package ru.weatherbot.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.weatherbot.database.Subscription;
import ru.weatherbot.weather.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Bot extends TelegramLongPollingBot {
    private Subscription subscription;

    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            List<Long> allUsers= null;
            try {
                allUsers = subscription.getAll();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            sendMessageToUsers(allUsers);
        }
    };

    public Bot() throws SQLException {
        super();
        subscription = new Subscription();
        subscription.createTable();

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        timer.schedule(timerTask, calendar.getTime(), 24 * 60 * 60 * 1000L);
    }

    @Override
    public String getBotUsername() {
        return "MyWeatherBot_qwelkjjfhj_bot";
    }

    @Override
    public String getBotToken() {
        return "1754182827:AAFXjZtw-DSKJO9e5OsCk415LGDtfyFK3VY";
    }

    private void sendMessageToUsers(List<Long> allUsers){
        for(Long user : allUsers){
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(user));
            message.setText("Вы подписаны на ежедневную рассылку прогноза погоды");
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
            // Set variables
            String input = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();// Create a message object
            message.setChatId(String.valueOf(chatId));

            try {
                if (update.getMessage().hasLocation()) {
                    double latitude = update.getMessage().getLocation().getLatitude();
                    double longitude = update.getMessage().getLocation().getLongitude();
                    try {
                        message.setText(Weather.getWeather(latitude, longitude));
                    } catch(IOException e) {
                        message.setText("Ошибка обработки погоды");
                        execute(message);
                    }
                    execute(message);
                } else if (update.getMessage().hasText()) {
                    if (input.startsWith("/start")) {
                        message.setText("Привет, я Weather Bot:) \n Я помогу подсказать тебе погоду, пришли мне геолокацию - я сообщу тебе текущую погоду и погоду на след день");
                        execute(message);
                    } else if (input.startsWith("/subscribe")) {
                        subscription.addToTable(chatId);
                        message.setText("Вы подписаны на ежедневную рассылку прогноза погоды");
                        execute(message);
                    } else if (input.startsWith("/unsubscribe")) {
                        subscription.deleteUser(chatId);
                        message.setText("Деактивировал вашу подписку :(");
                        execute(message);
                    } else if (input.startsWith("/help")) {
                        message.setText("Мои доступные команды: \n /start - начать работу со мной \n /help - получить помощь в работе со мной \n /subscribe - оформление ежедневной рассылки погоды \n /unsubscribe - отписаться от рассылки");
                        execute(message);
                    } else {
                        message.setText("Не понимаю вас, напишите /help чтобы узнать что я понимаю");
                        execute(message);
                    }
                }
            } catch (TelegramApiException | SQLException e) {
                e.printStackTrace();
            }
    }
}

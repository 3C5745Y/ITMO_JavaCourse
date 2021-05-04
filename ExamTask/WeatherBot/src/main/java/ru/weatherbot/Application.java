package ru.weatherbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.weatherbot.bot.Bot;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        Bot botApi = new Bot();

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(botApi);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

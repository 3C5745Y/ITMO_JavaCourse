package ru.weatherbot.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Subscription {
    final String database = "weatherbot.sqlite";
    private Connection connection = DriverManager.getConnection("jdbc:sqlite:" + database);
    ;

    public Subscription() throws SQLException {
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users ("
                    + " id         INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + " chat_id    INTEGER NOT NULL,"
                    + " last_visit INTEGER,"
                    + " visits     INTEGER"
                    + ")");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void addToTable(long chat_id) throws SQLException{
            PreparedStatement userExistStmt = connection.prepareStatement(
                    "SELECT COUNT(*) FROM users WHERE chat_id = ?");
            userExistStmt.setLong(1, chat_id);
            if (userExistStmt.executeQuery().getInt(1) == 0) {
                addUser(chat_id);
            }
    }

    private void addUser(long chat_id) throws SQLException {
        PreparedStatement insertStmt = connection.prepareStatement(
                "INSERT INTO users(chat_id, last_visit, visits) VALUES(?, CURRENT_TIMESTAMP, ?)");
        insertStmt.setLong(1, chat_id);
        insertStmt.setInt(2, 0);
        insertStmt.executeUpdate();
        ResultSet generatedKeys = insertStmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            System.out.format("Пользователь %s добавлен. id: %d%n",
                    chat_id, generatedKeys.getLong(1));
        }
    }

    public void deleteUser(long chat_id) throws SQLException {
        PreparedStatement deleteStmt = connection.prepareStatement(
                "DELETE FROM users WHERE chat_id = ?");
        deleteStmt.setLong(1, chat_id);
        deleteStmt.executeUpdate();
        ResultSet generatedKeys = deleteStmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            System.out.format("Пользователь %s удален. id: %d%n",
                    chat_id, generatedKeys.getLong(1));
        }
    }

    public List<Long> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT chat_id FROM users");

        List<Long> list = new ArrayList<>();
        while (result.next()) {
            list.add(result.getLong(1));
        }

        return list;
    }

//    private void showAllUsers() throws SQLException {
//        System.out.format("|%4s|%15s|%10s|%6s|%n", "id", "chat_id", "last_visit", "visits");
//        System.out.println("|----|---------------|----------|------|");
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(
//                "SELECT *, time(last_visit) AS last FROM users ORDER BY last_visit DESC");
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            int chat_id = rs.getInt("chat_id");
//            String lastTime = rs.getString("last");
//            int visits = rs.getInt("visits");
//            System.out.format("|%4d|%15s|%10s|%6d|%n", id, chat_id, lastTime, visits);
//        }
//    }
}

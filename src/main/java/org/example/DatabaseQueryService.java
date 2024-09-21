package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String DB_URL = "jdbc:h2:~/MyDB";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // Отримання всіх користувачів
    public List<User> getAllUsers() {
        String query = "SELECT * FROM Users";
        return executeUserQuery(query);
    }

    // Отримання користувача за ID
    public User getUserById(int id) {
        String query = "SELECT * FROM Users WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return mapUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Отримання активних користувачів
    public List<User> getActiveUsers() {
        String query = "SELECT * FROM Users WHERE status = 'active'";
        return executeUserQuery(query);
    }

    // Отримання кількості користувачів
    public int getUserCount() {
        String query = "SELECT COUNT(*) AS userCount FROM Users";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return resultSet.getInt("userCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Отримання клієнта з максимальною кількістю проектів
    public MaxProjectCountClient findMaxProjectsClient() {
        String query = "SELECT clientName, COUNT(*) AS projectCount " +
                "FROM Projects " +
                "GROUP BY clientName " +
                "ORDER BY projectCount DESC " +
                "LIMIT 1";
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String name = resultSet.getString("clientName");
                int projectCount = resultSet.getInt("projectCount");
                return new MaxProjectCountClient(name, projectCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Загальний метод для виконання запитів, що повертають список користувачів
    private List<User> executeUserQuery(String query) {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                users.add(mapUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Метод для перетворення ResultSet у об'єкт User
    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setStatus(resultSet.getString("status"));
        return user;
    }
}

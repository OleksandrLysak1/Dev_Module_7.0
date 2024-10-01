package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();

        try {
            String sql = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/init_db.sql")));
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.execute();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

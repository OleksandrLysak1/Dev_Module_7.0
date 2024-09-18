package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private final Database database;

    public DatabaseQueryService() {
        this.database = Database.getInstance();
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> clients = new ArrayList<>();
        String query = "SELECT c.NAME, COUNT(p.ID) AS PROJECT_COUNT " +
                "FROM client c " +
                "JOIN project p ON c.ID = p.CLIENT_ID " +
                "GROUP BY c.NAME " +
                "HAVING PROJECT_COUNT = (" +
                "    SELECT MAX(project_count) " +
                "    FROM (" +
                "        SELECT COUNT(ID) AS project_count " +
                "        FROM project " +
                "        GROUP BY CLIENT_ID" +
                "    ) AS temp" +
                ")";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");
                clients.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}

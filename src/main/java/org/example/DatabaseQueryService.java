package org.example;

import java.sql.Connection;
import java.sql.Date;
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
        String query = "SELECT client_id, COUNT(project_id) AS project_count " +
                "FROM projects " +
                "GROUP BY client_id " +
                "ORDER BY project_count DESC " +
                "LIMIT 1";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                int projectCount = resultSet.getInt("project_count");
                clients.add(new MaxProjectCountClient(clientId, projectCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}

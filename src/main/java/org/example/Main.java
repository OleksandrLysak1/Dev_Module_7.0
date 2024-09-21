package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DatabaseQueryService queryService = new DatabaseQueryService();
        MaxProjectCountClient maxClient = queryService.findMaxProjectsClient();
        System.out.println(maxClient != null ? maxClient : "No clients found.");
    }
}

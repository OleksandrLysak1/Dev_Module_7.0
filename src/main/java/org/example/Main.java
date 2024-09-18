package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        DatabaseQueryService queryService = new DatabaseQueryService();
        System.out.println(queryService.findMaxProjectsClient());
    }
}

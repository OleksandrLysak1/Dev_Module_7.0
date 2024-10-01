package org.example;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();

        long clientId = clientService.create("John Doe");
        System.out.println("Created client with ID: " + clientId);

        String clientName = clientService.getById(clientId);
        System.out.println("Client name: " + clientName);

        clientService.setName(clientId, "Jane Doe");
        System.out.println("Updated client name: " + clientService.getById(clientId));

        System.out.println("All clients: " + clientService.listAll());

        clientService.deleteById(clientId);
        System.out.println("Client deleted.");
    }
}

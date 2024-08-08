package com.example.test_prodject.service;

import com.example.test_prodject.dto.Client;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service

public class ClientService {
    public ClientService() {
        this.clients = new ArrayList<>();
    }
    private List<Client> clients;

    @PostConstruct
    public void createClients() {
        Faker faker = new Faker();
        List<Client> clientList = new ArrayList<>();
        clientList = IntStream.rangeClosed(1, 300).mapToObj(i -> Client.builder().
                clientId(Integer.toString(i)).name(faker.app().name()).
                middleName(faker.app().name()).
                surname(faker.app().name()).
                birthday(LocalDate.of(faker.number().numberBetween(1990, 2024), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28))).
                age((long) (faker.number().numberBetween(18, 100))).
                phone("+7" + faker.number().numberBetween(100000, 999999)+faker.number().numberBetween(1000, 9999)).
                build()).toList();
        clients.addAll(clientList);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClient() {
        return clients;
    }

    public Client getClient(String id) {
        return clients.stream().filter(x -> x.getClientId().equals(id)).findFirst().orElse(null);
    }
}

package com.example.demo.db;

import com.example.demo.dao.ClientRepository;
import com.example.demo.domain.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ClientData {

    @Bean
    public CommandLineRunner initDB(ClientRepository clientRepository) {
        return args -> {
            // Create a list of clients to be saved
            List<Client> clients = Arrays.asList(
                    new Client(1L, "Renos", "Bardis", "123 Main St", "renos@example.com", "Greek", 35),
                    new Client(2L, "John", "Doe", "456 Elm St", "john.doe@example.com", "American", 40),
                    new Client(3L, "Nick", "Smith", "789 Oak St", "nick.smith@example.com", "British", 28)
            );

            // Save all clients to the database
            clientRepository.saveAll(clients);
        };
    }
}

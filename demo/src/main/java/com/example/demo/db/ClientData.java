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
            // Create a list of clients without specifying IDs
            List<Client> clients = Arrays.asList(
                    new Client(null, "Renos", "Bardis", "123 Main St", "renos@example.com", "Greece", 35),
                    new Client(null, "John", "Doe", "456 Elm St", "john.doe@example.com", "Greece", 40),
                    new Client(null, "Nick", "Smith", "789 Oak St", "nick.smith@example.com", "Greece", 28)
            );

            // Save all clients to the database
            clientRepository.saveAll(clients);
        };
    }
}

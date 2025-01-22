package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.domain.Client;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    /**
     * Retrieves a list of all clients from the repository.
     * This method fetches all client records from the database and returns them as a list.
     *
     * @return A list of all clients stored in the database.
     */
    public List<Client> getAllCustomers() {
        return clientRepository.findAll();
    }

    /**
     * Inserts a new client into the repository.
     * This method takes a valid client object and saves it to the database.
     *
     * @param client The client object to be inserted into the repository.
     * @return The newly created client object, as saved in the repository.
     */
    @Transactional
    public Client insertNewClient(@Valid Client client) {
        return clientRepository.save(client);
    }
}

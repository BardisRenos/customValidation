package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.domain.Client;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     *
     * @return
     */
    public List<Client> getAllCustomers() {
        return clientRepository.findAll();
    }

    /**
     *
     * @param client
     * @return
     */
    public Client insertNewClient(@Valid Client client) {
        return clientRepository.save(client);
    }
}

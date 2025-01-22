package com.example.demo.controller;

import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client/")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    /**
     * Retrieves a list of all clients from the system.
     * This endpoint is accessible via a GET request.
     *
     * @return A list of all clients in the system.
     */
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllCustomers() {
        return clientService.getAllCustomers();
    }

    /**
     * Inserts a new client into the system.
     * This endpoint is accessible via a POST request with the client details in the request body.
     * The client object is validated before insertion.
     *
     * @param client The client to be inserted into the system.
     * @return The newly created client object.
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertCustomer(@Valid @RequestBody Client client) {
        return clientService.insertNewClient(client);
    }

}

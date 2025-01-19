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
     *
     * @return
     */
    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getAllCustomers() {
        return clientService.getAllCustomers();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertCustomer(@Valid @RequestBody Client client) {
        return clientService.insertNewClient(client);
    }

}

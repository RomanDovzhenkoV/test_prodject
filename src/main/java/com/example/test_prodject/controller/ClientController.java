package com.example.test_prodject.controller;

import com.example.test_prodject.dto.Client;
import com.example.test_prodject.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/getClient")
public class ClientController {
    private final ClientService service;

    @PostMapping("/addClient")
    public void addUser(@RequestBody Client client){
        service.addClient(client);
    }
    @GetMapping
    public List<Client> getClient(){
        return service.getClient();
    }

    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable String clientId) {
        return service.getClient(clientId);
    }
}

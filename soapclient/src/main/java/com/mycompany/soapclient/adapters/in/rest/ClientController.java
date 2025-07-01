package com.mycompany.soapclient.adapters.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycompany.soapclient.adapters.in.rest.dto.ClientDto;
import com.mycompany.soapclient.aplication.ClientService;
import com.mycompany.soapclient.domain.entities.Client;

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable String id) {
        Client client = clientService.getClientData(id);
        return ResponseEntity.ok(new ClientDto(client));
    }
}

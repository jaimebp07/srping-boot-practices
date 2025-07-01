package com.mycompany.soapclient.adapters.in.rest.dto;

import java.math.BigDecimal;

import com.mycompany.soapclient.domain.entities.Client;

import lombok.Data;

@Data
public class ClientDto {
     private String customerName;
    private String accountStatus;
    private BigDecimal totalBalance;

    public ClientDto(Client client) {
        this.customerName = client.getCustomerName();
        this.accountStatus = client.getAccountStatus();
        this.totalBalance = client.getTotalBalance().getValue();
    }
}

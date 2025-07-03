package com.mycompany.soapclient.domain.entities;

import lombok.Data;

@Data
public class Client {

    private String customerName;
    private Balance totalBalance;
    private String accountStatus;
    
}

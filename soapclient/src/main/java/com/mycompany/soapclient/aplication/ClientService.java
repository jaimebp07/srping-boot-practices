package com.mycompany.soapclient.aplication;

import com.mycompany.soapclient.domain.entities.Client;
import com.mycompany.soapclient.domain.out.ClientOutPort;


public class ClientService {

    private ClientOutPort clientOutPort;

    public ClientService( ClientOutPort clientOutPort){
        this.clientOutPort = clientOutPort;
    }

    public Client getClientData(String clientId) {
        return clientOutPort.getClientData(clientId);
    }

}

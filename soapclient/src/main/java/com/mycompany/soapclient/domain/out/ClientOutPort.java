package com.mycompany.soapclient.domain.out;

import com.mycompany.soapclient.domain.entities.Client;

public interface ClientOutPort {

    Client getClientData(String clientId);
}

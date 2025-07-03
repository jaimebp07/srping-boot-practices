package com.mycompany.soapclient.adapters.out;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.mycompany.soapclient.domain.entities.Balance;
import com.mycompany.soapclient.domain.entities.Client;
import com.mycompany.soapclient.domain.out.ClientOutPort;
import com.soap.wsdl.GetClientData;
import com.soap.wsdl.GetClientDataResponse;

public class ClientSoapAdapter extends WebServiceGatewaySupport implements ClientOutPort {
@Override
    public Client getClientData(String clientId) {
        GetClientData request = new GetClientData();
        request.setClientId(clientId);

        GetClientDataResponse response = (GetClientDataResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:5175/api/client/balance", request,
                        new SoapActionCallback("http://tempuri.org/GetClientData"));

        // Mapear respuesta SOAP a entidad de dominio
        Client client = new Client();
        client.setCustomerName(response.getGetClientDataResult().getCustomerName());
        client.setAccountStatus(response.getGetClientDataResult().getAccountStatus());

        Balance balance = new Balance();
        balance.setValue(response.getGetClientDataResult().getTotalBalance().getValue());
        client.setTotalBalance(balance);

        return client;
    }
}

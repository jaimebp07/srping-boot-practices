package com.mycompany.soapclient.infrastruture.soap.client;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.soap.wsdl.GetClientData;
import com.soap.wsdl.GetClientDataResponse;


public class ClientSoapAdapter extends WebServiceGatewaySupport {

    public GetClientDataResponse getClient() {

        GetClientData getClientDataRequest = new GetClientData();
        getClientDataRequest.setClientId("1"); //parece que el Id no hace nada en realidad

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/GetClientData");
        GetClientDataResponse getClientDataResponse = (GetClientDataResponse) getWebServiceTemplate().marshalSendAndReceive(
            "http://www.dneonline.com/calculator.asmx", 
            getClientDataRequest, 
            soapActionCallback);
        return getClientDataResponse;
    }

}

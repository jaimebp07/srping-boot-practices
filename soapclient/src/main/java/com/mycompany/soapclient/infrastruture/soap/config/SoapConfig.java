package com.mycompany.soapclient.infrastruture.soap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.mycompany.soapclient.adapters.out.ClientSoapAdapter;

@Configuration
public class SoapConfig {

     @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.wsdl");
        return marshaller;
    }

    @Bean
    public ClientSoapAdapter getSoapClient(Jaxb2Marshaller marshaller){
        ClientSoapAdapter soapClient = new ClientSoapAdapter();
        soapClient.setDefaultUri("http://localhost:5175/api/client/balance");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }
}

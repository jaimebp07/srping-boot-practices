package com.jaime.practices.practices1.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdEnvironment implements EnvironmentServices {

    @Override
    public String getEnvironmentString() {
        return "Prod";
    }

}

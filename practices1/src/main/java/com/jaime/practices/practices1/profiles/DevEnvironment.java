package com.jaime.practices.practices1.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile( value = {"dev", "default"}) //Default profile
public class DevEnvironment implements EnvironmentServices {

    @Override
    public String getEnvironmentString() {
        return "Dev";
    }   

}

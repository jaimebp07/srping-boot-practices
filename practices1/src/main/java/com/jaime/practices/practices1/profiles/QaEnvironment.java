package com.jaime.practices.practices1.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaEnvironment implements EnvironmentServices{

    @Override
    public String getEnvironmentString() {
        return "QA";
    }

}

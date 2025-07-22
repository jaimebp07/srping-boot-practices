package com.mycompany.roles_and_auth.infrastructure.adapter.out.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mycompany.roles_and_auth.domain.port.out.PasswordEncoderPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PasswordEncoderAdapter implements PasswordEncoderPort {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encode(String rawPassword){
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}

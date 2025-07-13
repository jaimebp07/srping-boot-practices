package com.mycompany.roles_and_auth.domain.models;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {

    private String email;
    private String name;
    private String password;
    private Set<Role> roles;
}

package com.mycompany.roles_and_auth.infrastructure.adapter.in.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.mycompany.roles_and_auth.domain.models.Role;
import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.infrastructure.adapter.in.dto.UserDTO;

public class UserMapper {

    public static User toDomain(UserDTO dto) {
        Set<Role> roles = dto.getRoles().stream().map(Role::valueOf).collect(Collectors.toSet());
        User user = User.builder().name(dto.getUsername()).email(dto.getEmail()).password(dto.getPassword()).roles(roles).build();
        return user;
    }
}

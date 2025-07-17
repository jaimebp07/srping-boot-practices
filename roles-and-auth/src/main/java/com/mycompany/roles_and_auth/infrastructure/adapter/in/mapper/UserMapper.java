package com.mycompany.roles_and_auth.infrastructure.adapter.in.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mycompany.roles_and_auth.domain.model.Role;
import com.mycompany.roles_and_auth.domain.model.User;
import com.mycompany.roles_and_auth.infrastructure.adapter.in.dto.UserDTO;

@Component
public class UserMapper {

    public User toDomain(UserDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("UserDTO must not be null");
        }

        Set<Role> roles = mapRoles(dto.getRoles());

        return new User(
                dto.getEmail(),
                dto.getUsername(),
                dto.getPassword(),
                roles
        );
    }

    private Set<Role> mapRoles(Set<String> roleStrings) {
        if (roleStrings == null || roleStrings.isEmpty()) {
            throw new IllegalArgumentException("At least one role must be assigned");
        }

        return roleStrings.stream()
                .map(this::safeMapToRole)
                .collect(Collectors.toSet());
    }

    private Role safeMapToRole(String roleStr) {
        try {
            return Role.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Invalid role: " + roleStr);
        }
    }
}

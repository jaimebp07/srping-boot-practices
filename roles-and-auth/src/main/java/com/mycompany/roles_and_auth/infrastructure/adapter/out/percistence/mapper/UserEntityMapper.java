package com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.entity.RoleEntity;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.entity.UserEntity;

@Component
public class UserEntityMapper {

public UserEntity toEntity(User userDomain) {
        Set<RoleEntity> roles = userDomain.getRoles().stream()
            .map(rol -> RoleEntity.builder()
                        .role(rol)
                        .build())
                        .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
         .username(userDomain.getName())
         .email(userDomain.getEmail())
         .password(userDomain.getPassword())
         .roles(roles)
         .build();
        return userEntity;
    }
}
package com.mycompany.roles_and_auth.infrastructure.adapter.out;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.domain.port.out.UserRepositoryPort;
import com.mycompany.roles_and_auth.infrastructure.entity.RoleEntity;
import com.mycompany.roles_and_auth.infrastructure.entity.UserEntity;
import com.mycompany.roles_and_auth.infrastructure.repository.UserJpaRepository;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private UserJpaRepository userJpaRepository;

     public UserRepositoryAdapter(UserJpaRepository jpaRepository){
        this.userJpaRepository = jpaRepository;
    }

    @Override
    public boolean save(User userDomain) {
       
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

        UserEntity saved = userJpaRepository.save(userEntity);
        return saved != null && saved.getId() != null;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            if(this.userJpaRepository.existsById(id)){
                this.userJpaRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}

package com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence;

import org.springframework.stereotype.Repository;

import com.mycompany.roles_and_auth.domain.model.User;
import com.mycompany.roles_and_auth.domain.port.out.UserRepositoryPort;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.entity.UserEntity;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.mapper.UserEntityMapper;
import com.mycompany.roles_and_auth.infrastructure.repository.UserJpaRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepositoryAdapter implements UserRepositoryPort {

    private UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository, UserEntityMapper userEntityMapper){
        this.userJpaRepository = jpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public boolean save(User userDomain) {
        try {
            UserEntity entity = userEntityMapper.toEntity(userDomain);
            UserEntity saved = userJpaRepository.save(entity);
            return saved != null && saved.getId() != null;
        } catch (Exception e) {
            log.error("Error while saving user: {}", userDomain.getEmail(), e);
            return false;
        }
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
             log.error("Error while deleting user by id: {}", id, e);
            return false;
        }
    }
}

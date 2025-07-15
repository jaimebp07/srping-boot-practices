package com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence;

import org.springframework.stereotype.Repository;

import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.domain.port.out.UserRepositoryPort;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.entity.UserEntity;
import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.mapper.UserEntityMapper;
import com.mycompany.roles_and_auth.infrastructure.repository.UserJpaRepository;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

    private UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryAdapter(UserJpaRepository jpaRepository, UserEntityMapper userEntityMapper){
        this.userJpaRepository = jpaRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public boolean save(User userDomain) {
          UserEntity entity = userEntityMapper.toEntity(userDomain);
        UserEntity saved = userJpaRepository.save(entity);
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

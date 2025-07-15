package com.mycompany.roles_and_auth.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.roles_and_auth.infrastructure.adapter.out.percistence.entity.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}

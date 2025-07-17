package com.mycompany.roles_and_auth.aplication.service;

import org.springframework.stereotype.Service;

import com.mycompany.roles_and_auth.domain.model.User;
import com.mycompany.roles_and_auth.domain.port.in.UserServicePort;
import com.mycompany.roles_and_auth.domain.port.out.UserRepositoryPort;

@Service
public class UserService implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean createUser(User user) {
        return userRepositoryPort.save(user);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepositoryPort.deleteById(id);
    }
}

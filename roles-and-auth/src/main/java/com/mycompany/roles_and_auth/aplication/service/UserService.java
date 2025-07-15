package com.mycompany.roles_and_auth.aplication.service;

import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.domain.port.in.UserServicePort;
import com.mycompany.roles_and_auth.domain.port.out.UserRepositoryPort;

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

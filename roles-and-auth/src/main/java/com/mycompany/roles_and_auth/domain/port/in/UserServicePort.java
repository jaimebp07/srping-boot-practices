package com.mycompany.roles_and_auth.domain.port.in;

import com.mycompany.roles_and_auth.domain.models.User;

public interface UserServicePort {

    boolean createUser(User user);
    boolean deleteUserById(Long id);
}

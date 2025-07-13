package com.mycompany.roles_and_auth.domain.port.out;

import com.mycompany.roles_and_auth.domain.models.User;

public interface UserRepositoryPort {

    boolean save(User user);
    boolean deleteById(Long id);

}

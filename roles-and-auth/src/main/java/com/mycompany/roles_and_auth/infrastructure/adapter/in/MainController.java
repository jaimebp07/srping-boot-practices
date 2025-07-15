package com.mycompany.roles_and_auth.infrastructure.adapter.in;

import org.springframework.web.bind.annotation.RestController;

import com.mycompany.roles_and_auth.aplication.service.UserService;
import com.mycompany.roles_and_auth.domain.models.User;
import com.mycompany.roles_and_auth.domain.port.in.UserServicePort;
import com.mycompany.roles_and_auth.infrastructure.adapter.in.dto.UserDTO;
import com.mycompany.roles_and_auth.infrastructure.adapter.in.mapper.UserMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MainController {

    private UserServicePort userServicePort;

    public MainController(UserService userServicePort){
        this.userServicePort = userServicePort;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world not secured";
    }

    @GetMapping("/helloSecured")
    public String helloSecured() {
        return "Hello world secured";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
        User user = UserMapper.toDomain(userDTO);
        boolean isCreate = this.userServicePort.createUser(user);
        return  isCreate ? ResponseEntity.ok().body("User created") : ResponseEntity.badRequest().body("Cannot create user");
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUser( @PathVariable  Long id){
        boolean deleted = this.userServicePort.deleteUserById(id);
        return deleted? ResponseEntity.ok().body("User deleted"):ResponseEntity.badRequest().body("Cannot delete user");
    }
}

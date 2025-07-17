package com.mycompany.roles_and_auth.domain.model;

import java.util.Set;

//No es recomendable utilizar anotacionesen el dominio, ya que estas le dan dependencia de la tecnologia que se esta utilizando.
public class User {

    private final String email;
    private final String username;
    private final String password;
    private final Set<Role> roles;

    public User(String email, String username, String password, Set<Role> roles) {
        if (email == null || email.isBlank() || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (username == null || username.isBlank() || username.length() > 30) {
            throw new IllegalArgumentException("Nombre de usuario inválido");
        }
        if (password == null || password.isBlank() || password.length() < 6) {
            throw new IllegalArgumentException("La contraseña es demasiado corta");
        }
        if (roles == null || roles.isEmpty()) {
            throw new IllegalArgumentException("Debe tener al menos un rol");
        }

        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = Set.copyOf(roles); // Inmutable
    }

    // Getters (no setters para mantener inmutabilidad)
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Set<Role> getRoles() { return roles; }
}

package com.segurancaa.kelly.Bunisses;

import com.segurancaa.kelly.Infrascture.Entites.User;
import com.segurancaa.kelly.Infrascture.Repository.UserRepository;
import com.segurancaa.kelly.role.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean userExists(String login) {
        return repository.findByUsername(login) != null;
    }

    public void registerUser(String login, String password, String roleStr) {
        if (userExists(login)) {
            throw new RuntimeException("Usuario ja existe");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        UserRole roleEnum;
        try {
            roleEnum = UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Role invalido! Use Admin ou User.");
        }

        User newUser = new User(login, encryptedPassword, roleEnum);
        repository.save(newUser);
    }

    public User loadUserByUsername(String login) {
        User user = repository.findByUsername(login);
        if (user == null) {
            throw new RuntimeException("Usuario nao encontrado");
        }
        return user;
    }
}
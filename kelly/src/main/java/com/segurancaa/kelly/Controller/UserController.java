package com.segurancaa.kelly.Controller;

import com.segurancaa.kelly.Dto.RegisterDto;
import com.segurancaa.kelly.Infrascture.Entites.User;
import com.segurancaa.kelly.Infrascture.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;

    public UserController(AuthenticationManager authenticationManager, UserRepository repository) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterDto data) {
        if (this.repository.findByUsername(data.login()) != null) {
            return ResponseEntity.badRequest().body("Usuario ja existe");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        this.repository.save(newUser);

        return ResponseEntity.ok("Usuario registrado com sucesso");
    }
}

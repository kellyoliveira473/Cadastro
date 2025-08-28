package com.segurancaa.kelly.Infrascture.Repository;

import com.segurancaa.kelly.Infrascture.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

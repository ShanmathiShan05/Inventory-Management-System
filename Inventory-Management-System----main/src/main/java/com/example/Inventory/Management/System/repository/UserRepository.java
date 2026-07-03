package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventory.Management.System.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
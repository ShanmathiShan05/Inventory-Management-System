package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
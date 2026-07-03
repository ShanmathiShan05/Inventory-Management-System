package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
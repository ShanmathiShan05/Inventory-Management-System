package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.entity.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
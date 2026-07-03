package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
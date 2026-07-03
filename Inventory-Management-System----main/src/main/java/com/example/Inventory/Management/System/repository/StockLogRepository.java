package com.example.Inventory.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.Management.System.entity.StockLog;

import java.util.List;

public interface StockLogRepository extends JpaRepository<StockLog, Long> {

    List<StockLog> findTop10ByOrderByChangeDateDesc();

    List<StockLog> findByProductId(Long productId);
}
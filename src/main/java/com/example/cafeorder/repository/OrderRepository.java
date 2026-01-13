package com.example.cafeorder.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cafeorder.model.dto.PopularMenuResponse;
import com.example.cafeorder.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

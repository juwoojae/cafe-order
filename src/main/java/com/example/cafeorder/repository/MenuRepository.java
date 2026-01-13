package com.example.cafeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeorder.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}

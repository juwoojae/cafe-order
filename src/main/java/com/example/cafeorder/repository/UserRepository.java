package com.example.cafeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeorder.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

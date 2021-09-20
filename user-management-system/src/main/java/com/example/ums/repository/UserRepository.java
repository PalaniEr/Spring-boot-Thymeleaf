package com.example.ums.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ums.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

package com.antchb.examples.spring.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antchb.examples.spring.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

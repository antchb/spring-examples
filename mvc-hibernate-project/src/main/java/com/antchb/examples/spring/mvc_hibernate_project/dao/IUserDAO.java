package com.antchb.examples.spring.mvc_hibernate_project.dao;

import java.util.List;
import java.util.Optional;

import com.antchb.examples.spring.mvc_hibernate_project.entity.User;

public interface IUserDAO {

    List<User> getAll();

    Optional<User> get(Long id);

    void add(User user);

    void delete(Long id);

    void update(Long id, User user);

}

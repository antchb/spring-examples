package com.antchb.examples.spring.mvc_hibernate_project.service;

import java.util.List;
import java.util.Optional;

import com.antchb.examples.spring.mvc_hibernate_project.entity.User;

public interface IUserService {

    List<User> getUsers();

    Optional<User> getUser(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User user);

}

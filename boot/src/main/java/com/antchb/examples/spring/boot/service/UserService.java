package com.antchb.examples.spring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antchb.examples.spring.boot.dao.UserRepository;
import com.antchb.examples.spring.boot.entity.User;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
       userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
       userRepository.deleteById(id);
    }

}

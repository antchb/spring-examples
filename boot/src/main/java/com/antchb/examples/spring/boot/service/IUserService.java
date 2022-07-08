package com.antchb.examples.spring.boot.service;

import java.util.List;
import java.util.Optional;

import com.antchb.examples.spring.boot.entity.User;

public interface IUserService {

    public List<User> getAll();
   
    public Optional<User> get(Long id);
    
    public void save(User user);

    public void delete(Long id);
}

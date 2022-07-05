package com.antchb.examples.spring.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.antchb.examples.spring.rest.dao.IUserDAO;
import com.antchb.examples.spring.rest.entity.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getAll();
    }

    @Override
    @Transactional
    public Optional<User> getUser(Long id) {
        return userDAO.get(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
       userDAO.add(user); 
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
       userDAO.delete(id); 
    }

    @Override
    @Transactional
    public void updateUser(Long id, User user) {
       userDAO.update(id, user); 
    }

}

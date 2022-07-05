package com.antchb.examples.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antchb.examples.spring.rest.entity.User;
import com.antchb.examples.spring.rest.exception.UserNotFoundException;
import com.antchb.examples.spring.rest.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUser(userId);
        
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId);
        }
        
        return user.get();
    }
    
    /*
     * curl -X POST -H "Content-Type: application/json" \
     *      -d '{"userId":null, "lastName":"Tester", "firstName":"Test", "email":"test@example.com", "updDate":null}' \
     *      http://localhost:8080/rest/api/users
     */

    // It is not a good practice to have an entity instead of POJO object 
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setUserId(null);
        userService.addUser(user);

        return user;
    }

    /*
     * curl -X PUT -H "Content-Type: application/json" \
     *      -d '{"userId":1, "lastName":"T", "firstName":"Tester", "email":"test@example.com", "updDate":null}' \
     *      http://localhost:8080/rest/api/users
     */
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user.getUserId(), user);
        
        return user;
    }
    
    // curl -X DELETE http://localhost:8080/rest/api/users/1
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return "Success";
    }
    
}

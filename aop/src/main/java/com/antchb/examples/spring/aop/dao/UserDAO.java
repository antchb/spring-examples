package com.antchb.examples.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO implements IUserDAO {

    @Override
    public void dbLogic() {
        System.out.println("### Emulating DB actions...");
    }

}

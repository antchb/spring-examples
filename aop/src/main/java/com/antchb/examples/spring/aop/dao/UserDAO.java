package com.antchb.examples.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO implements IUserDAO {

    @Override
    public void dbLogic(String input) {
        System.out.println("### Emulating DB actions...");
    }

    @Override
    public void extraLogic() {
        System.out.println("### Emulating Extra DB actions. Should not be covered by Aspects");
    }
}

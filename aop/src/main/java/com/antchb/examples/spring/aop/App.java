package com.antchb.examples.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.antchb.examples.spring.aop.dao.IUserDAO;

public class App {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context 
                = new AnnotationConfigApplicationContext(AppConfiguration.class)) {

            IUserDAO userDAO = context.getBean("userDAO", IUserDAO.class);
            userDAO.dbLogic();
            userDAO.extraLogic();
        }
    }

}

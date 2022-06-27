package com.antchb.examples.spring.aop.dao;

public interface IUserDAO {

    void dbLogic(String input);

    void extraLogic();
}

package com.antchb.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // @Aspect Type + Pointcut Expression Language (wildcard: [*], param-pattern: (), (*) - one argument, (..) >= 0)
    @Before("execution(public * com.antchb.examples.spring.aop.dao.IUserDAO.dbLogic(..))")
    public void loggingDaoAspect() {
        System.out.println("\n### Applying Aspect Logging Logic (@Before)... Success!");
    }

}

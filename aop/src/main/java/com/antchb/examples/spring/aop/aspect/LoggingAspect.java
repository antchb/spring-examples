package com.antchb.examples.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // Can be negative. Lower value has higher priority
public class LoggingAspect {

    @Pointcut("execution(* com.antchb.examples.spring.aop.dao.*.*(..))")
    private void allDaoPackagePointcut() { }
    
    @Pointcut("execution(* com.antchb.examples.spring.aop.dao.*.extra*(..))")
    private void allDaoPackageExtraLogicPointcut() { }

    @Pointcut("allDaoPackagePointcut() && !allDaoPackageExtraLogicPointcut()")
    private void allDaoWithoutExtraLogicPointcut() { }

    // @Aspect Type + Pointcut Expression Language (wildcard: [*], param-pattern: (), (*) - one argument, (..) >= 0)
    @Before("execution(public * com.antchb.examples.spring.aop.dao.IUserDAO.dbLogic(..))")
    public void loggingDaoAspect() {
        System.out.println("\n\t*** Applying Aspect Logging Logic (@Before)... Success!");
    }

    @Before("allDaoWithoutExtraLogicPointcut()")
    public void loggingAllDaoPointcutDeclaration() {
        System.out.println("\n\t*** Applying Aspect (@Before) with pointcut declaration... Success!");
    }
    
}

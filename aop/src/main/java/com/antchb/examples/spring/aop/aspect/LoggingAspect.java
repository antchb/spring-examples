package com.antchb.examples.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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

    /*
     * - @AfterReturning(pointcut = "pointcut()", returning = "value")
     * - @AfterThrowing(pointcut = "pointcut()", throwing = "exceptionArgName")
     * - @After("pointcut()")
     * - @Around("pointcut()") + ProceedingJoinPoint to add additional logic inside a pointcut method. For example to
     *   check how long does it take to execute a function or functions
    */
    @Before("allDaoWithoutExtraLogicPointcut()")
    public void loggingAllDaoPointcutDeclaration(JoinPoint joinPoint) {
        System.out.println("\n\t*** Applying Aspect (@Before) with pointcut declaration... Success!");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("\t*** Aspect. Method Signature: " + signature);

        Object[] args = joinPoint.getArgs();

        for (Object o : args) {
            System.out.println("\t*** Aspect. Argument Value: " + o);
        }
    }
    
}

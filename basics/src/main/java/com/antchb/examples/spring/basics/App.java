package com.antchb.examples.spring.basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.antchb.examples.spring.basics.sport_event.ChessEvent;
import com.antchb.examples.spring.basics.sport_event.ISportEvent;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-context.xml");

        // Step 1
        System.out.println("\n### An Example of IoC (Inversion Of Control). An XML Configuration decides on which object " +
                           "is going to be generated ###\n");
      
        ISportEvent sport = context.getBean("sportEvent", ISportEvent.class);
        System.out.println(sport.getDescription());

        // Step 2
        System.out.println("\n### An Example of DI (Dependency Injection) - Constructor ###\n");
       
        ISportEvent sportEventDiConstructor = context.getBean("sportEventDependencyInjection", ISportEvent.class);
        System.out.println("# Description: " + sportEventDiConstructor.getDescription() + "\n");
        System.out.println("# Slogan: " + sportEventDiConstructor.getSlogan());

        // Step 3
        System.out.println("\n### An Example of DI (Dependency Injection) - Setter ###\n");
        
        ISportEvent sportEventDiSetter = context.getBean("sportEventDependencyInjectionSetter", ISportEvent.class);
        System.out.println("# Description: " + sportEventDiSetter.getDescription() + "\n");
        System.out.println("# Slogan: " + sportEventDiSetter.getSlogan());
       
        // Step 4
        System.out.println("\n### An Example of DI (Dependency Injection) - Setter for a field ###\n");
       
        ChessEvent chessEvent = context.getBean("chessEvent", ChessEvent.class);
        System.out.println("# Contact Name: " + chessEvent.getContactName());

        // Step 5
        System.out.println("\n### An Example of DI (Dependency Injection) - Setter for literals with " + 
                           "a property file ###\n");
      
        ChessEvent chessEventFromProps = context.getBean("chessEventFileProps", ChessEvent.class);
        System.out.println("# Contact Name: " + chessEventFromProps.getContactName());

        // Step 6
        System.out.println("\n### An Example of DI (Dependency Injection) - Init List of Values ###\n");

        ISportEvent eventWithRandomSlogan = context.getBean("sportEventWithRandomSlogan", ISportEvent.class); 
        System.out.println("# Random Slogan: " + eventWithRandomSlogan.getSlogan());

        // Step 7
        System.out.println("\n### An Example of Bean Scopes. Singleton (default) + Prototype ###\n");
        ISportEvent oneSingleton = context.getBean("singleton", ISportEvent.class);
        ISportEvent twoSingleton = context.getBean("singleton", ISportEvent.class);

        System.out.println("# Result of comparing two singletons (one == two): " + (oneSingleton == twoSingleton));

        ISportEvent onePrototype = context.getBean("prototype", ISportEvent.class);
        ISportEvent twoPrototype = context.getBean("prototype", ISportEvent.class);

        System.out.println("# Result of comparing two prototypes (one == two): " + (onePrototype == twoPrototype));

        // Step 8
        System.out.println("\n### An Example of Bean Lifecycle (Hooks / Init + Destroy Method) ###\n");
        ISportEvent lifecycleMethods = context.getBean("lifecycleMethodsBean", ISportEvent.class);

        System.out.println("\n### For Prototype Scoped Beans Spring do not call destroy method. To support it a custom bean processor is required ###\n");
        ChessEvent prototypeWithDestroyMethod = context.getBean("prototypeWithDestroyMethod", ChessEvent.class);

        context.close();
    }
}

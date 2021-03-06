package com.antchb.examples.spring.basics;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.antchb.examples.spring.basics.sport_event.ChessEvent;
import com.antchb.examples.spring.basics.sport_event.HockeyEvent;
import com.antchb.examples.spring.basics.sport_event.ISportEvent;

public class App {
    
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Select a configuration type:\n");
            System.out.println("\t[1]: XML Configuration");
            System.out.println("\t[2]: Java Annotations Configuration");
            System.out.println("\t[3]: Java Only Configuration (No XML)");
            
            System.out.print("\n### Selected Option: ");

            String option = in.nextLine();

            switch(option) {
                case "1" -> xmlConfiguration(); 
                case "2" -> javaAnnotationsConfiguration();
                case "3" -> javaOnlyConfiguration();
                default -> System.out.println("Wrong option was selected. Please, run again");
            }
        }
    }

    public static void xmlConfiguration() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-xml-context.xml");

        // Step 1
        System.out.println("\n### An Example of IoC (Inversion Of Control). An XML Configuration decides on which " +
                           "object will be generated ###\n");
      
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
        System.out.println("# Slogan: " + lifecycleMethods.getSlogan());

        System.out.println("\n### For Prototype Scoped Beans Spring do not call destroy method. To support it a " +
                           "custom bean processor is required ###\n");
        ChessEvent prototypeWithDestroyMethod = context.getBean("prototypeWithDestroyMethod", ChessEvent.class);
        System.out.println("# Slogan: " + prototypeWithDestroyMethod.getSlogan());

        context.close();
    }

    private static void javaAnnotationsConfiguration() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotations-context.xml");

        // Step 1
        System.out.println("\n### An Example of IoC (Inversion Of Control). An XML Configuration enables Annotation " +
                           "scanning and it decides what object will be generated ###\n");
        ISportEvent sportEvent = context.getBean("hockeyEventBeanId", ISportEvent.class);
        System.out.println("# Description: " + sportEvent.getDescription());
        System.out.println("# Slogan: " + sportEvent.getSlogan());

        // NOTE: Choose a style and stay consistent in your project

        // Step 2
        System.out.println("\n### An Example of Dependency Injection (DI) - Constructor. @Autowired annotation " +
                           "is used. If there are too many implementations then @Qualifier must be used ###\n");
        ISportEvent autowiredConstructor = context.getBean("footballEvent", ISportEvent.class);
        System.out.println("# Description: " + autowiredConstructor.getDescription() + "\n");
        System.out.println("# Slogan: " + autowiredConstructor.getSlogan());
        
        // Step 3
        System.out.println("\n### An Example of Dependency Injection (DI) - Setter (Method Injection). " +
                           "It can be used with any method ###\n");
        ISportEvent autowiredSetter = context.getBean("americanFootballEvent", ISportEvent.class);
        System.out.println("# Description: " + autowiredSetter.getDescription() + "\n");
        System.out.println("# Slogan: " + autowiredSetter.getSlogan());
        
        // Step 4
        System.out.println("\n### An Example of Dependency Injection (DI) - Field Injection. " +
                           "No setters required. It uses Java Reflection ###\n");
        ISportEvent fieldInjectionBean = context.getBean("volleyballEvent", ISportEvent.class);
        System.out.println("# Description: " + fieldInjectionBean.getDescription() + "\n");
        System.out.println("# Slogan: " + fieldInjectionBean.getSlogan());

        // Step 5
        System.out.println("\n### An Example of Dependency Injection (DI) - Properties Injection ###\n");
        HockeyEvent hockeyEventProperties = context.getBean("hockeyEventBeanId", HockeyEvent.class);
        System.out.println("# Contact name: " + hockeyEventProperties.getContactName());

        // Step 6
        System.out.println("\n### An Example of Dependency Injection (DI) - Random values from the file " +
                           "+ Post Construct Example ###\n");
        ISportEvent randomValues = context.getBean("boxingEvent", ISportEvent.class);
        System.out.println("# Description: " + randomValues.getDescription() + "\n");
        System.out.println("# Slogan: " + randomValues.getSlogan());

        // Step 7
        System.out.println("\n### An Example of Bean Scopes. Singleton (default) + Prototype ###\n");
        ISportEvent oneSingleton = context.getBean("footballEvent", ISportEvent.class);
        ISportEvent twoSingleton = context.getBean("footballEvent", ISportEvent.class);

        System.out.println("# Result of comparing two singletons (one == two): " + (oneSingleton == twoSingleton));

        ISportEvent onePrototype = context.getBean("boxingEvent", ISportEvent.class);
        ISportEvent twoPrototype = context.getBean("boxingEvent", ISportEvent.class);

        System.out.println("# Result of comparing two prototypes (one == two): " + (onePrototype == twoPrototype));
        context.close();
    }

    private static void javaOnlyConfiguration() {
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(SportEventConfiguration.class);

        // Step 1
        System.out.println("\n### An Example of IoC (Inversion Of Control). Java Config. Class enables " +
                           "scanning and it decides what object will be generated ###\n"); 
        ISportEvent sportEvent = context.getBean("footballEvent", ISportEvent.class);
        System.out.println("# Description: " + sportEvent.getDescription());
        System.out.println("# Slogan: " + sportEvent.getSlogan());

        // Step 2
        // You can use @Bean to make an existing third-party class available in your Spring framework application context
        System.out.println("\n### An Example of manual bean creation + DI for Java Only Configuration ###\n");
        ISportEvent chessEvent = context.getBean("chessEvent", ISportEvent.class);
        System.out.println("# Description: " + chessEvent.getDescription());
        System.out.println("# Slogan: " + chessEvent.getSlogan());

        // Step 3
        System.out.println("\n### An Example of Dependency Injection (DI) - Properties Injection ###\n");
        HockeyEvent hockeyEventProperties = context.getBean("hockeyEventBeanId", HockeyEvent.class);
        System.out.println("# Contact name: " + hockeyEventProperties.getContactName());

        context.close();
    }
}

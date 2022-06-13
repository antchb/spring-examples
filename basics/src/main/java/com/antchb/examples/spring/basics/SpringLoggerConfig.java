package com.antchb.examples.spring.basics;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLoggerConfig {

    private String rootLoggerLevel;
    private String printedLoggerLevel;

    public SpringLoggerConfig() { }

    public SpringLoggerConfig(String rootLoggerLevel, String printedLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
        this.printedLoggerLevel = printedLoggerLevel;

		initLogger();
    }

    public void setRootLoggerLevel(String rootLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
    }

    public void setPrintedLoggerLevel(String printedLoggerLevel) {
        this.printedLoggerLevel = printedLoggerLevel;
    }

    public void initLogger() {
        Level rootLevel = Level.parse(rootLoggerLevel);
        Level printedLevel = Level.parse(printedLoggerLevel);
        
        Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
        Logger loggerParent = applicationContextLogger.getParent();

        loggerParent.setLevel(rootLevel);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printedLevel);
        consoleHandler.setFormatter(new SimpleFormatter());
        
        loggerParent.addHandler(consoleHandler);
    }
    
}

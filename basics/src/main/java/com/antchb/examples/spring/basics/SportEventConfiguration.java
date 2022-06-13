package com.antchb.examples.spring.basics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.antchb.examples.spring.basics.slogan.ISlogan;
import com.antchb.examples.spring.basics.slogan.SimpleSlogan;
import com.antchb.examples.spring.basics.sport_event.ChessEvent;

@Configuration
@ComponentScan("com.antchb.examples.spring.basics")
@PropertySource("classpath:logger.properties")
public class SportEventConfiguration {

    // In Spring 5.1, the Spring Development team changed the logging levels internally
    // As a result, by default you will no longer see the red logging messages at the INFO level
    // This bean resolves the problem
    @Bean
    public SpringLoggerConfig myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
                                             @Value("${printed.logger.level}") String printedLoggerLevel) {
        SpringLoggerConfig SpringLoggerConfig = new SpringLoggerConfig(rootLoggerLevel, printedLoggerLevel);

        return SpringLoggerConfig;
    }

    @Bean
    public ISlogan simpleSlogan() {
        return new SimpleSlogan();
    }

    @Bean
    public ChessEvent chessEvent() {
        return new ChessEvent(simpleSlogan());
    }

}
package com.antchb.examples.spring.basics.slogan;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRandomSlogan implements ISlogan {

    private Random random;
    private List<String> slogans;

    public FileRandomSlogan(@Value("${file.slogans}") String filePath) {
        this.slogans = getSlogansFromFile(filePath);
        this.random = new Random();
    }

    private List<String> getSlogansFromFile(String filePath) {
        List<String> slogans = new ArrayList<>();

        // Only for debug purposes. It is not going to work with JAR
        try (Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(filePath).toURI()))) {
            stream.filter(i -> !i.isBlank()).forEach(i -> slogans.add(i));
        } catch (Exception e) {
            System.out.println("Cannot load the file! " + e);
        }
        
        return slogans;
    }

    @Override
    public String getSlogan() {
        return slogans.size() != 0 ? slogans.get(random.nextInt(slogans.size())) : "";
    }
   
    // To enable @PostConstruct or @PreDestroy annotations we need to import javax.annotation library 
    // because it was removed from the standard JDK 9+
    // The method can have any access modifier and any name, but it must have no args
    @PostConstruct
    private void postConstructActivities() {
        System.out.println("### Post Construct Activities... Manual Method!");
    }

}

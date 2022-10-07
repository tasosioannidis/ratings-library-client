package com.baeldung.evaluation.ratings.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.evaluation.ratings.lib.annotation.ReviewableSupport;

/**
 *
 * @author rozagerardo
 */
@SpringBootApplication
@ReviewableSupport
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

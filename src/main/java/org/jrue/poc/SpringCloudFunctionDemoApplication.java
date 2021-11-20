package org.jrue.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionDemoApplication implements Function<String, String> {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionDemoApplication.class, args);
    }

    @Override
    public String apply(String input) {
        return String.format("Hello %s", input);
    }
}

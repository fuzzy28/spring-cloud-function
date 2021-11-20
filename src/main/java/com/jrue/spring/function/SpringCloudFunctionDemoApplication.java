package com.jrue.spring.function;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;

@SpringBootConfiguration
public class SpringCloudFunctionDemoApplication implements ApplicationContextInitializer<GenericApplicationContext> {

    public static void main(String[] args) {

    }

    public Function<String, String> sayHello() {
        return name -> String.format("Hello %s", name);
    }

    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean("sayHello", FunctionRegistration.class,
                () -> new FunctionRegistration<>(sayHello()).type(FunctionType.from(String.class).to(String.class)));
    }
}

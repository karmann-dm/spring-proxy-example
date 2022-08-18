package com.example.springproxyexample;

import com.example.springproxyexample.some.SomeAnnotatedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProxyExampleApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringProxyExampleApplication.class, args);
    }

    @Autowired
    private SomeAnnotatedClass someAnnotatedClass;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        someAnnotatedClass.someMethod();

        someAnnotatedClass.anotherMethod();
    }
}

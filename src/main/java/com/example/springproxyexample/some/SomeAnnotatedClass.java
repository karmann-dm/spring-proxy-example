package com.example.springproxyexample.some;

import com.example.springproxyexample.ClassBasedAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@ClassBasedAnnotation("value to be logged")
@Slf4j
public class SomeAnnotatedClass {
    public void someMethod() {
        log.info("Do some method");
    }

    public void anotherMethod() {
        log.info("Do another method");
    }
}

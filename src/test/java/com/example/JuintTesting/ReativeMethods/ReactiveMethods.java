package com.example.JuintTesting.ReativeMethods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

public class ReactiveMethods {

    @Test
    public void testZip(){
        Flux<String> name = Flux.just("udhaya" , "kumar","satish");
        Flux<Integer> age = Flux.just(12,13,12);
        Flux<String> subject = Flux.just("Tamil" , "English" , "Maths");

        Flux<Student> stringFlux = Flux.zip(name, age, subject)
                .map(tuple -> new Student(tuple.getT1(), tuple.getT2(), tuple.getT3()));
        stringFlux.subscribe(System.out::println);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Student {
        private String name;
        private int age;
        private String subjects;
    }
}

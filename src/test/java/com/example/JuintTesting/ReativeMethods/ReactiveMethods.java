package com.example.JuintTesting.ReativeMethods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import static reactor.core.scheduler.Schedulers.parallel;

public class ReactiveMethods {

    @Test
    public void testZip(){
        Flux<String> name = Flux.just("udhaya" , "kumar","satish");
        Flux<Integer> age = Flux.just(12,13,12);
        Flux<String> subject = Flux.just("Tamil" , "English" , "Maths");

        Flux<Student> studentFlux = name.zipWith(age).map(tuple -> new Student(tuple.getT1(), tuple.getT2()));
        studentFlux.subscribe(System.out::println);
    }

    @Test
    public void testMap(){
        Flux<Student> studentFlux = Flux.just(
                new Student("udhaya" , 20 , "Tamil"),
                new Student("Kumar" , 21 , "English"),
                new Student("Deepak" , 21 , "Maths"),
                new Student("udhaya1" , 22 , "social"),
                new Student("Kumar1" , 24 , "Biology"),
                new Student("Deepak1" , 22 , "science")
        );
//        Flux<String> map = studentFlux.map(Student::getName).log();
//        map.subscribe(System.out::println);
        Flux<String> stringFlux = studentFlux
                .window(2)
                .concatMap(stud -> stud.flatMap(student -> Flux.just(student.getName())))
                .subscribeOn(parallel());
        stringFlux.subscribe(value -> System.out.println(value));
        stringFlux.blockLast();


    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    class Student {
        private String name;
        private int age;
        private String subjects;
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

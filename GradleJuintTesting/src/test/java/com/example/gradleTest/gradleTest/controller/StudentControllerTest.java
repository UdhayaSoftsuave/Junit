package com.example.gradleTest.gradleTest.controller;

import com.example.gradleTest.gradleTest.entity.Student;
import com.example.gradleTest.gradleTest.service.StudentService;
import com.lordofthejars.nosqlunit.annotation.CustomComparisonStrategy;
import com.lordofthejars.nosqlunit.annotation.IgnorePropertyValue;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.lordofthejars.nosqlunit.mongodb.MongoFlexibleComparisonStrategy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import static com.lordofthejars.nosqlunit.mongodb.ManagedMongoDb.MongoServerRuleBuilder.newManagedMongoDbRule;
import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CustomComparisonStrategy(comparisonStrategy = MongoFlexibleComparisonStrategy.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentControllerTest {

    @Autowired
    private WebTestClient wtc;

    @Inject
    private ApplicationContext context;

    @BeforeAll
    public void setUp() {
        this.wtc = WebTestClient.bindToApplicationContext(this.context)
                .configureClient()
                .build();
    }
    @Rule
    public ManagedMongoDb managedMongoDb = newManagedMongoDbRule().mongodPath("C:\\Program Files\\MongoDB\\Server\\6.0").appendSingleCommandLineArguments("-vvv").build();

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("TestStudent");

    @Test
    @UsingDataSet(locations = "StudentControllerTest#saveStudent.json")
    @ShouldMatchDataSet(location = "StudentControllerTest#saveStudent-expected.json")
    @IgnorePropertyValue(properties = {"student._id"})
    public void saveStudent() throws JSONException {
        JSONObject command = new JSONObject();
        command.put("id" , "647866de4e309516a8b2a853")
                .put("name" , "udhaya")
                .put("age", 23)
                .put("std" , 78);

        wtc.post().uri("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(command.toString()))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class)
                .consumeWith(result -> {
                    Student view = result.getResponseBody();
                    assertNotNull(view);
                });
    }

    @Test
    @UsingDataSet(locations = {"StudentControllerTest#getAllStudents.json"})
    @ShouldMatchDataSet(location = "StudentControllerTest#getAllStudents-expected.json")
    @IgnorePropertyValue(properties = {"student._id"})
    public void getAllStudents() {

        wtc.get().uri("/student")
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class)
                .consumeWith(result -> {
                    List<Student> view = (List<Student>)result.getResponseBody();
                    assertNotNull(view);
                });
    }
    @Test
    @UsingDataSet(locations = {"StudentControllerTest#getStudentById.json"})
    @ShouldMatchDataSet(location = "StudentControllerTest#getStudentById-expected.json")
    @IgnorePropertyValue(properties = {"student._id"})
    public void getStudentById() {

        wtc.get().uri("/student/id/{id}","647866de4e309516a8b2a853")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Student.class)
                .consumeWith(result -> {
                    Student view = result.getResponseBody();
                    assertNotNull(view);
                    System.out.println(view);
                    Assertions.assertTrue(true);
                });
    }

//    @GetMapping("/id/{id}")
//    public Mono<Student> getById(@PathVariable("id") String id){
//        return studentService.getStudentById(id);
//    }

//    @GetMapping("/name/{name}")
//    public Mono<Student> getByName(@PathVariable("name") String name){
//        return studentService.getStudentByName(name);
//    }

//    @PutMapping("/{id}")
//    public Mono<Student> update(@PathVariable("id") String id , @RequestBody Student student){
//        return studentService.updateStudent(id , student);
//    }

//    @DeleteMapping("/{id}")
//    public Mono<String> delete(@PathVariable("id") String id ){
//        return studentService.delete(id);
//    }
}


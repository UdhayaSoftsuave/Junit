package com.example.JuintTesting;

import com.example.JuintTesting.dto.Student;
import com.example.JuintTesting.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;

@SpringBootTest(properties = {"spring.mongodb.embedded.version=5.0.6"})
@AutoConfigureWebTestClient
@Testcontainers
class JuintTestingApplicationTests {

	@Container
	static RabbitMQContainer rabbitContainer = new RabbitMQContainer("rabbitmq:3.7.25-management-alpine");

	@Autowired
	WebTestClient client;

	@Autowired
	StudentRepository studentRepository;

	@DynamicPropertySource
	static void configure(DynamicPropertyRegistry registry) {
		registry.add("spring.rabbitmq.host", rabbitContainer::getHost);
		registry.add("spring.rabbitmq.port", rabbitContainer::getAmqpPort);
	}

	@BeforeEach
	void setUp() {
		studentRepository.findAll()
				.flatMap(studentRepository::delete)
				.blockLast();
	}

	@Test
	void itemsAreAdded_viaAmqp() {
		client.post()
				.uri("/student")
				.bodyValue(new Student("6","udhaya",23,7))
				.exchange()
				.expectStatus().isOk()
				.expectBody();

		Flux<Student> Students = studentRepository.findAll();
		Students.subscribe(student ->{
			Assertions.assertEquals( "udhaya", student.getName());
			Assertions.assertEquals(23, student.getAge());
			Assertions.assertEquals(7,student.getStd());
		});
	}

}

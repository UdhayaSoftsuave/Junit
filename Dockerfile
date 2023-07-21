FROM openjdk:17.0.1-jdk-slim

ENV RABBITMQ_ROUTEE_SERVICE_SERVICE_HOST=172.23.224.1

COPY target/JuintTesting-0.0.1-SNAPSHOT.jar /app/service.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "service.jar"]

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/jobapplication-microservice-0.0.1-SNAPSHOT.jar /app/jobapplication-microservice-0.0.1-SNAPSHOT.jar
EXPOSE 8087
CMD ["java", "-jar", "jobapplication-microservice-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/employease-0.0.1-SNAPSHOT.jar /app/employease.jar
EXPOSE 5454
CMD ["java", "-jar", "employease.jar"]
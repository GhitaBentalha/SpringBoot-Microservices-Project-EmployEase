FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Gateway-0.0.1-SNAPSHOT.jar /app/Gateway-0.0.1-SNAPSHOT.jar
EXPOSE 8084
CMD ["java", "-jar", "Gateway-0.0.1-SNAPSHOT.jar"]
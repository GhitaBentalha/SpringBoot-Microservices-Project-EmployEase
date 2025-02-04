# Utiliser une image de base avec Java
FROM openjdk:17-jdk-alpine

# Copier le fichier JAR du microservice
COPY target/*.jar /app/app.jar

# Exposer le port du microservice
EXPOSE 5454

# Commande pour exécuter le microservice
ENTRYPOINT ["java", "-jar", "app.jar"] 
# Étape de build avec Maven et JDK 17
FROM maven:3.9.8-eclipse-temurin-17 AS build

WORKDIR /app

# Copie des fichiers nécessaires pour la construction
COPY pom.xml .
COPY src ./src

# Construction de l'application (en sautant les tests pour accélérer le build)
RUN mvn clean package -DskipTests

# Étape d'exécution avec JRE 17 seulement (plus léger)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Argument pour le nom du fichier JAR (correspondant à votre pom.xml)
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar

# Copie du JAR depuis l'étape de build
COPY --from=build /app/${JAR_FILE} app.jar

# Exposition du port par défaut de Spring Boot
EXPOSE 8080

# Point d'entrée pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
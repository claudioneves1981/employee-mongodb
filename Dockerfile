FROM maven:3.9.7-sapmachine-22 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:22-slim
COPY --from=build /target/*.jar employee-mongodb.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employee-mongodb.jar"]
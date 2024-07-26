FROM openjdk:22
LABEL authors="user"
EXPOSE 8080
ADD /target/hello-events.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
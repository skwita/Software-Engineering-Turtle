FROM openjdk:11
COPY target/turtle-0.0.1-SNAPSHOT.jar turtle-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/turtle-0.0.1-SNAPSHOT.jar"]
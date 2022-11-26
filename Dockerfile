FROM maven:3-amazoncorretto-11 as builder

ADD ./pom.xml pom.xml
ADD ./src src/

RUN mvn -f pom.xml clean package

FROM openjdk:11.0-jre-slim
COPY --from=builder target/turtle-0.0.1-SNAPSHOT.jar turtle-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "turtle-0.0.1-SNAPSHOT.jar"]
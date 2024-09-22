FROM openjdk:17
WORKDIR /app
COPY target/jobs-0.0.1-SNAPSHOT.jar /app/jobs-0.0.1.jar
ENTRYPOINT ["java", "-jar", "jobs-0.0.1.jar"]


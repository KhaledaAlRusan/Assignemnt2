# First stage: build the application
FROM maven:3.6.3-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package

# Second stage: run the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/ebtisamAbdulk_midterm-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

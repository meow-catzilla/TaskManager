#FROM eclipse-temurin:21-jdk AS build
#WORKDIR /app

#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .

#RUN ./mvnw dependency:go-offline

#COPY src src
#RUN ./mvnw clean package -DskipTests

#-----------------------------------------------

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY ./target/TaskManager-0.0.1-SNAPSHOT.war /app
ENTRYPOINT ["java","-jar","TaskManager-0.0.1-SNAPSHOT.war"]




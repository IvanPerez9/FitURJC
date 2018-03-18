FROM alpine/git as clone
WORKDIR /app
RUN git clone https://github.com/IvanPerez9/FitURJC.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clone /app/FitURJC /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /
RUN mkdir temp
WORKDIR /temp
RUN mkdir images
WORKDIR /temp/images
COPY --from=build /app/docker/default default
WORKDIR /app
COPY --from=build /app/target/FitURJC-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/FitURJC-0.0.1-SNAPSHOT.jar"]

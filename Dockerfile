FROM openjdk:8-jdk-alpine
WORKDIR /
RUN mkdir temp
WORKDIR /temp
RUN mkdir images
WORKDIR /temp/images
COPY default default
WORKDIR /app
VOLUME /tmp
ARG JAR_FILE
ADD FitURJC-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM openjdk:8
ADD src/main/resources/docker-database.properties /classes/database.properties
ADD target/sct-springboot-1.0-SNAPSHOT.jar sct-springboot-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java","-cp", "/classes" , "-jar","sct-springboot-1.0-SNAPSHOT.jar" ] 

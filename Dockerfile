FROM openjdk:8
ADD /build/libs/*.jar SimpleTextEditor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "SimpleTextEditor.jar"]


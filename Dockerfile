FROM openjdk:17
VOLUME /tmp
ADD target/csbank-0.0.1-SNAPSHOT.jar csbank.jar

EXPOSE 8080 8080

ENTRYPOINT ["java","-jar","csbank.jar"]
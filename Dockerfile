FROM adoptopenjdk/openjdk8-openj9

COPY target/passenger-service-0.0.1-SNAPSHOT.jar  /

ENTRYPOINT exec java -jar passenger-service-0.0.1-SNAPSHOT.jar
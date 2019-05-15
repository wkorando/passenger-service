FROM adoptopenjdk/openjdk8-openj9

COPY target/passenger-service-0.0.1-SNAPSHOT.jar  /

ENTRYPOINT exec java -jar passenger-service-0.0.1-SNAPSHOT.jar --spring.datasource.username=$POSTGRES_USERNAME --spring.datasource.password=$POSTGRES_PASSWORD --spring.kafka.jaas.options.username=$KAFKA_USERNAME --spring.kafka.jaas.options.password=$KAFKA_PASSWORD
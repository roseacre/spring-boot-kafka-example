# spring-boot-kafka-example

This rough and ready application demonstrates the use of sping-kafka, as based on the description at https://www.geeksforgeeks.org/advance-java/spring-boot-integration-with-kafka/

## Assumptions

Kafka has been downloaded locally to Downloads/kafka_2.13-4.0.0

## Create a cluster ID
As I haven't configured a single variable for the cluster_id, there needs to be a bit of manual intervention before it all works.
In a terminal window,
```
$ cd Downloads/kafka_2.13-4.0.0

$ KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"

$ export KAFKA_CLUSTER_ID

$ bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/server.properties

```

## Ensure the cluster ID is available for use in the application

It appears a few times in the app and for ease/laziness I've just pasted it in once I've displayed the value from a
```
$ echo $KAFKA_CLUSTER_ID
```

The value needs to be changed in
line 3 - /src/main/resources/application.properties
line 23 - /src/main/java/uk/gov/dwp/health/springbootkafkaexample/config/KafkaConsumerConfig.java
line 9 - /src/main/java/uk/gov/dwp/health/springbootkafkaexample/service/KafkaConsumerService.java

## Start the kafka server

In a terminal window, where kafka is downloaded to unless it's configured to be more widely available,

```
$ bin/kafka-server-start.sh config/server.properties
```

## Start the spring boot application

I've just clicked the arrow on line 7 in /src/main/java/uk/gov/dwp/health/springbootkafkaexample/SpringBootKafkaExampleApplication.java


## Test

In Insomnia, create a GET request to url http://localhost:8080/send?message=HelloKafka

In the logs of the spring boot application there should be
```
Message sent: HelloKafka
Message received: "HelloKafka"
```

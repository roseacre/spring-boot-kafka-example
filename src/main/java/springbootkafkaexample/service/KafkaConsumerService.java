package springbootkafkaexample.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my_topic", groupId = "KZ4Ey69XSoWzWvlz2WPHOg")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}

package com.example.kafkademo.consumer;

import com.example.kafkademo.payload.Student;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "DinhSon", groupId = "myGroup")
    public void consume(@NotNull Student student) {
        log.info(String.format("Consumed message: %s", student.toString()));
    }

//    @KafkaListener(topics = "DinhSon", groupId = "myGroup")
//    public void consume(String message) {
//        log.info(String.format("Consumed message: %s", message));
//    }
}

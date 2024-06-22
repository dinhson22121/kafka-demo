package com.example.kafkademo.config.producer;

import com.example.kafkademo.payload.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Student student) {
        Message<Student> message = MessageBuilder.withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "DinhSon").build();

        kafkaTemplate.send(message);
    }
}

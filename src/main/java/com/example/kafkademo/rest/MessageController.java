package com.example.kafkademo.rest;

import com.example.kafkademo.config.producer.KafkaJsonProducer;
import com.example.kafkademo.config.producer.KafkaProducer;
import com.example.kafkademo.payload.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        var toppic = "DinhSon";
        kafkaProducer.sendMessage(toppic,message);
        return ResponseEntity.ok("Message queue successfully");
    }

    @PostMapping("json")
    public ResponseEntity<?> sendJsonMessage(@RequestBody Student message){
        var toppic = "DinhSon";
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message with Json queue successfully");
    }
}

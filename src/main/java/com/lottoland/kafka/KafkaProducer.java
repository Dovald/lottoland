package com.lottoland.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.lottoland.entity.JankenEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

  @Autowired
  private final KafkaTemplate<String, JankenEntity> kafkaJankenTemplate;
  
  @Autowired
  private final KafkaTemplate<String, String> kafkaResetTemplate;  

  @Value(value = "${spring.kafka.topic.janken}")
  private String topicJanken;
  
  @Value(value = "${spring.kafka.topic.reset}")
  private String topicReset;

  public void sendJanken(JankenEntity jankenEntity) {
    
    System.out.println(String.format("Janken Message sent -> %s", jankenEntity.toString()));

    Message<JankenEntity> message = MessageBuilder
            .withPayload(jankenEntity)
            .setHeader(KafkaHeaders.TOPIC, topicJanken)
            .build();

    kafkaJankenTemplate.send(message);
  }
  
  public void sendReset(String sessionID) {
	    
    System.out.println(String.format("Reset Message sent -> %s", sessionID));

    Message<String> message = MessageBuilder
            .withPayload(sessionID)
            .setHeader(KafkaHeaders.TOPIC, topicReset)
            .build();

    kafkaResetTemplate.send(message);
  }
}
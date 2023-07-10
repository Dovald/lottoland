package com.lottoland.kafka;


import java.util.Collection;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.lottoland.entity.JankenEntity;

@Component
public class KafkaConsumer {

	public Multimap<String, JankenEntity> games = Multimaps.synchronizedMultimap(HashMultimap.<String, JankenEntity>create());


	@KafkaListener(topics = "${spring.kafka.topic.janken}")
	public void listeningJanken(JankenEntity jankenEntity) {
		System.out.println(String.format("Janken Message received -> %s", jankenEntity.toString()));
		games.put(jankenEntity.getSessionID(), jankenEntity);
	}
		  
	@KafkaListener(topics = "${spring.kafka.topic.reset}")
	public void listeningReset(String sessionID) {
		System.out.println(String.format("Reset Message received -> %s", sessionID));
		Collection<JankenEntity> values = games.get(sessionID);

		 synchronized (games) {
			 values.forEach(janken -> janken.setReset(true));
		 }
	}
}

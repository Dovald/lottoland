package com.lottoland.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottoland.dto.JankenDTO;
import com.lottoland.entity.JankenEntity;
import com.lottoland.exception.InvalidIdException;
import com.lottoland.kafka.KafkaProducer;

@Service
public class JankenService {
	
	private static String[] hands = {"Rock", "Paper", "Scissors"};
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private KafkaProducer kafkaProducer;

	public String reset(String sessionID) {
		validateSessionID(sessionID);
		kafkaProducer.sendReset(sessionID);
		return "OK";
	}


	public JankenDTO round(String sessionID) {
		validateSessionID(sessionID);
		JankenDTO jankenDTO = new JankenDTO();	
		long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String formattedDate = dateFormat.format(currentDate);
		
		jankenDTO.setPlayer1(hand());
		jankenDTO.setPlayer2("Rock");
		jankenDTO.setPlayedAt(formattedDate);
		play(jankenDTO);
		
		JankenEntity jankenEntity = modelMapper.map(jankenDTO, JankenEntity.class);
		jankenEntity.setSessionID(sessionID);		
		
		kafkaProducer.sendJanken(jankenEntity);

		return jankenDTO;
	}
	
	private void play(JankenDTO jankenDTO) {
		switch(jankenDTO.getPlayer1()){
		
		case "Rock":
			jankenDTO.setResult("Tie");
			break;
		case "Paper":
			jankenDTO.setResult("Player1 Wins");
			break;
		case "Scissors":
			jankenDTO.setResult("Player2 Wins");
			break;
		default: break;
		}		
	}

	private String hand(){
		Random rand = new Random();
        int randomNumber = rand.nextInt(3);
        
        return hands[randomNumber];
	}
	
	private void validateSessionID(String sessionID) throws InvalidIdException {
	    String pattern = "^[a-zA-Z0-9-]+$";
	    if (!sessionID.matches(pattern)) {
	        throw new InvalidIdException("Invalid sessionID supplied");
	    }
	}
}

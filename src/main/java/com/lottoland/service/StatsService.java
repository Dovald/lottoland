package com.lottoland.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottoland.dto.GlobalStatsJankenDTO;
import com.lottoland.dto.JankenDTO;
import com.lottoland.dto.StatsJankenDTO;
import com.lottoland.entity.JankenEntity;
import com.lottoland.exception.InvalidIdException;
import com.lottoland.kafka.KafkaConsumer;

@Service
public class StatsService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private KafkaConsumer kafkaConsumer;

	public GlobalStatsJankenDTO globalStats() {
		GlobalStatsJankenDTO globalStatsJankenDTO = new GlobalStatsJankenDTO();
		
		globalStatsJankenDTO.setTotalTies(kafkaConsumer.games.values().stream().filter(round -> round.getResult().equals("Tie")).count());
		globalStatsJankenDTO.setTotalP1Wins(kafkaConsumer.games.values().stream().filter(round -> round.getResult().equals("Player1 Wins")).count());
		globalStatsJankenDTO.setTotalP2Wins(kafkaConsumer.games.values().stream().filter(round -> round.getResult().equals("Player2 Wins")).count());
		globalStatsJankenDTO.setTotalRounds(globalStatsJankenDTO.getTotalP1Wins() + globalStatsJankenDTO.getTotalP2Wins() + globalStatsJankenDTO.getTotalTies());
		
		return globalStatsJankenDTO;
	}

	public StatsJankenDTO statsBySessionID(String sessionID) {
		validateSessionID(sessionID);
		Collection<JankenEntity> games = kafkaConsumer.games.get(sessionID);
		StatsJankenDTO result = new StatsJankenDTO();
		result.setRounds(games.stream().filter(game -> !game.isReset()).map(game -> modelMapper.map(game, JankenDTO.class)).collect(Collectors.toList()));
		
		return result;
	}
	
	private void validateSessionID(String sessionID) throws InvalidIdException {
	    String pattern = "^[a-zA-Z0-9-]+$";
	    if (!sessionID.matches(pattern)) {
	        throw new InvalidIdException("Invalid sessionID supplied");
	    }
	}
}

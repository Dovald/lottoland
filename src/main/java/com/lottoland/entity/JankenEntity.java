package com.lottoland.entity;

import lombok.Data;

@Data
public class JankenEntity {

	  private String player1 = null;

	  private String player2 = null;

	  private String result = null;
	  
	  private String sessionID = null;
	  
	  private boolean reset = false;
	  
	  private String playedAt = null;
}

package com.lottoland.exception;

public class InvalidIdException extends RuntimeException{

	private static final long serialVersionUID = 1363849454906985289L;
	
	public InvalidIdException(String errorMessage) {
        super(errorMessage);
    }

}

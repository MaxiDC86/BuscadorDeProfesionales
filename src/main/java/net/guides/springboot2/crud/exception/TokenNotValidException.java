package net.guides.springboot2.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class TokenNotValidException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TokenNotValidException(String message) {
		super(message);
	}

}

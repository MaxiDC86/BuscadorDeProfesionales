package net.guides.springboot2.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import net.guides.springboot2.crud.model.Token;
import net.guides.springboot2.crud.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public Token findByValue(long id) {
		return tokenRepository.findById(id);
	}

}

package token.application.validateToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import token.domain.Token;
import token.domain.TokenInvalidException;
import token.domain.TokenValidator;

@Service
public class ValidateTokenService {
	
	private TokenValidator tokenValidator;
	
	@Autowired
	public ValidateTokenService(TokenValidator tokenValidator) {
		this.tokenValidator = tokenValidator;
	}
	
	public boolean execute(Token tok)  {
		return tokenValidator.validate(tok);
	}
}

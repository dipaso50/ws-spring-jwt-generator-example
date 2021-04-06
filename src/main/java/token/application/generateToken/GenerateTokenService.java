package token.application.generateToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

import token.domain.Token;
import token.domain.TokenGenerator;
import token.domain.TokenInvalidException;
import token.domain.User;

@Component("generateTokenService")
public class GenerateTokenService {
	
	private TokenGenerator tokenGenerator;
	
	@Autowired
	public GenerateTokenService(TokenGenerator tokenGenerator) {
		this.tokenGenerator = tokenGenerator;
	}
	
	public Token execute(User user) throws TokenInvalidException {
		return tokenGenerator.generateToken(user);
	}
}

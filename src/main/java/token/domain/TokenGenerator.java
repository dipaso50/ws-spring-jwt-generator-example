package token.domain;

public interface TokenGenerator {	
	public Token generateToken(User user) throws TokenInvalidException;
}

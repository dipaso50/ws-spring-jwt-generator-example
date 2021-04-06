package token.domain;

public class TokenInvalidException extends Exception {
	
	public TokenInvalidException() {
		super();
	}
	
	public TokenInvalidException(String message) {
		super(message);
	}
}

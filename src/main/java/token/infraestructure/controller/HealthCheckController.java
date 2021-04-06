package token.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import token.application.generateToken.GenerateTokenService;
import token.application.validateToken.ValidateTokenService;
import token.domain.Token;
import token.domain.TokenInvalidException;
import token.domain.User;

@RestController
public class HealthCheckController {
	
	@Autowired()
	private GenerateTokenService generateTokenService; 
	
	@Autowired()
	private ValidateTokenService validateTokenService;

	@RequestMapping("/")
	public String healthCheck() {		
		return "All ok!";
	}
	
	@RequestMapping("/generateToken")
	public String generateToken() {
		try {
			
			Token tok = generateTokenService.execute(new User("Jhon", "doe"));
			
			boolean validToken = validateTokenService.execute(tok);
			
			return  validToken + " " + tok.getValue();
			
		}catch(TokenInvalidException tokenInvalid) {
			return "KO";
		} catch (Exception e) {
			return "KO";
		} 
	}
}

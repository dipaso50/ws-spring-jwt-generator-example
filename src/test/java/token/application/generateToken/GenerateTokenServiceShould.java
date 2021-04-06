package token.application.generateToken;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import token.domain.Token;
import token.domain.TokenGenerator;
import token.domain.TokenInvalidException;
import token.domain.User;
import token.infraestructure.Entry;

 
@ContextConfiguration(classes=Entry.class)
@SpringBootTest
public class GenerateTokenServiceShould {
	 
	private TokenGenerator tokenGenerator;

	private GenerateTokenService generateTokenService;
	
	private User usr ;
	
	@Before
	public void setUp() throws Exception {	
		
		usr = new User("Jhon", "Doe");
		
		tokenGenerator = Mockito.mock(TokenGenerator.class);
		generateTokenService = new GenerateTokenService(tokenGenerator);
		
	    Mockito.when(tokenGenerator.generateToken(usr)).thenReturn((new Token(usr.getName() + usr.getLastName())));	
	}
	
	@Test
	public void create_a_expected_token() throws TokenInvalidException {				
		Token tok = generateTokenService.execute(usr);
		assertEquals(new Token(usr.getName() + usr.getLastName()), tok);
	}
	
	 
}

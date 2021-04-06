package token.application.validateToken;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import token.application.validateToken.ValidateTokenService;
import token.domain.TokenValidator;
import token.infraestructure.Entry;

@ContextConfiguration(classes=Entry.class)
@SpringBootTest
public class ValidateTokenServiceShould {

	private TokenValidator tokenValidator;
	private ValidateTokenService validateTokenService;
	
	@Before
	public void setUp() throws Exception {
		tokenValidator = Mockito.mock(TokenValidator.class);
		validateTokenService = new ValidateTokenService(tokenValidator); 
	}
	
	@Test
	public void return_true_when_token_is_valid() {
		 Mockito.when(tokenValidator.validate(null)).thenReturn(true);	
		 assertTrue(validateTokenService.execute(null));
	}
	
	@Test
	public void return_false_when_token_is_invalid() {
		 Mockito.when(tokenValidator.validate(null)).thenReturn(false);	
		 assertFalse(validateTokenService.execute(null));
	}
}

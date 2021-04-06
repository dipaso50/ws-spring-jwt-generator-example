package token.infraestructure;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import token.domain.Token;
import token.domain.TokenInvalidException;
import token.domain.User;

@ContextConfiguration(classes=Entry.class)
@SpringBootTest
public class JWTGeneratorValidatorShould {

	@Test
	public void generate_a_valid_token() throws TokenInvalidException, Exception {
		
		JWTGeneratorValidator generatorValidator = new JWTGeneratorValidator();
		
		Token tok = generatorValidator.generateToken(new User("Jhon", "Doe"));
		
		assertTrue(generatorValidator.validate(tok));
	}
}

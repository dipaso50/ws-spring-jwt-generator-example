package token.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import token.infraestructure.Entry;

@ContextConfiguration(classes=Entry.class)
@SpringBootTest
public class TokenShould {
	
	@Test(expected = TokenInvalidException.class)
	public void throws_a_exception_when_token_null() throws TokenInvalidException {		 
		new Token(null);
	}
	
	@Test(expected = TokenInvalidException.class)
	public void throws_a_exception_when_token_isEmpty() throws TokenInvalidException {		 
		new Token(" ");
	}
	
	@Test()
	public void be_equals_to_another_with_same_value() throws TokenInvalidException {		 
		Token tok1 = new Token("1234");
		Token tok2 = new Token("1234");
		
		assertEquals(tok1, tok2);
	}

}

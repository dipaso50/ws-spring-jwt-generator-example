package token.domain;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import token.infraestructure.Entry;

@ContextConfiguration(classes=Entry.class)
@SpringBootTest
public class UserShould {

	private static final String expectedMessage = "Invalid user name or user lastname";
	@Test()
	public void throws_a_exception_when_user_params_are_null() throws Exception {		 

		Exception exception = assertThrows(Exception.class, () -> {
			new User(null, null);
		});

		
		assertTrue(exception.getMessage().contains(expectedMessage));
 

		exception = assertThrows(Exception.class, () -> {
			new User("d", null);
		});


		assertTrue(exception.getMessage().contains(expectedMessage)); 

		exception = assertThrows(Exception.class, () -> {
			new User(null, "d");
		});

		assertTrue(exception.getMessage().contains(expectedMessage));

	}

	@Test()
	public void throws_a_exception_when_user_params_are_isEmpty() throws Exception {		 
		 

		Exception exception = assertThrows(Exception.class, () -> {
			new User("", " ");
		});

		
		assertTrue(exception.getMessage().contains(expectedMessage));
 

		exception = assertThrows(Exception.class, () -> {
			new User(" ", "d");
		});


		assertTrue(exception.getMessage().contains(expectedMessage)); 

		exception = assertThrows(Exception.class, () -> {
			new User("d", " ");
		});

		assertTrue(exception.getMessage().contains(expectedMessage));
	}


}

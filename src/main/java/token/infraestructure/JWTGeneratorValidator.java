package token.infraestructure;
 
import java.security.Key;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims; 
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm; 
import io.jsonwebtoken.security.Keys; 
import token.domain.Token;
import token.domain.TokenGenerator;
import token.domain.TokenInvalidException;
import token.domain.TokenValidator;
import token.domain.User;

@Service
public class JWTGeneratorValidator implements TokenGenerator , TokenValidator{	
	
	private static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);   
	
	@Override
	public Token generateToken(User user) throws TokenInvalidException {
		
		 String id = UUID.randomUUID().toString().replace("-", "");

	        Date now = new Date();
	        Date exp = new Date(System.currentTimeMillis() + (1000*30)); // 30 seconds

	        String token =  Jwts.builder()
	                .setId(id)
	                .setIssuedAt(now)
	                .setNotBefore(now)
	                .setExpiration(exp)
	                .claim("name", user.getName())
	                .claim("lastName", user.getLastName())
	                .signWith(key)
	                .compact();
	         	
	        return new Token(token);
	}

	@Override
	public boolean validate(Token token) {		
		 Claims claims = Jwts.parser()
		            .setSigningKey(key)
		            .parseClaimsJws(token.getValue()).getBody();
		 return true; 
	}
}

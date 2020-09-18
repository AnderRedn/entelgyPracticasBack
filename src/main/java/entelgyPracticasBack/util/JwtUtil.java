package entelgyPracticasBack.util;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	public String getToken(String employee) {
		Instant now = Instant.now();
		String jwt = Jwts.builder().setSubject(employee).setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
				.signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret)).compact();
		return jwt;
	}
}

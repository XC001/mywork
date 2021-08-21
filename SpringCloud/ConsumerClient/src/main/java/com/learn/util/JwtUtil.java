package com.learn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.*;
import java.util.Date;

public class JwtUtil {
    public static String getJwtToken(String payload){
        Algorithm algorithm = Algorithm.HMAC256("secret");

        return JWT.create()
                .withIssuer("auth0")
                .withClaim("payload", payload)
                .withExpiresAt(Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.of("Asia/Shanghai")).toInstant()))
                .sign(algorithm);
    }

    public static String validateJwtToken(String token) throws JWTVerificationException{
        Algorithm algorithm = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("payload").asString();
    }
}

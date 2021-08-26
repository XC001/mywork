package com.learn.consumerclient;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.learn.test.BusiController;
import com.learn.util.JwtUtil;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public class DateTest {

    @Test
    public void main() {
        System.out.println(Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.of("Asia/Shanghai")).toInstant()));

        Algorithm algorithm = Algorithm.HMAC256("secret");
        String a = JWT.create()
                .withIssuer("auth0")
                .withClaim("payload", "admin")
                .withExpiresAt(new Date())
                .sign(algorithm);
        String b = JWT.create()
                .withIssuer("auth0")
                .withClaim("payload", "admin")
                .withExpiresAt(new Date())
                .sign(algorithm);
        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void testJwtGetToken(){
        JwtUtil.getJwtToken("123");
    }

    @Test
    public void testJwtValidateToken(){
        JwtUtil.validateJwtToken(JwtUtil.getJwtToken("123"));
    }

    @Test
    public void testGetWorkDay(){
        BusiController busiController = new BusiController();
        busiController.getWorkDay("1");
    }
}

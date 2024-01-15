package com.ali.socialmedia.core.utils.jwtService;

import com.ali.socialmedia.entities.concretes.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JwtService {
    Algorithm algorithm = Algorithm.HMAC256("secret");
    public String generateToken(User user){
        Date now = new Date();
        return JWT.create()
                .withIssuer("auth0")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(now.getTime() + 2 * 60 * 60 * 1000))
                .withClaim("username",user.getUsername())
                .sign(algorithm);
    }

    public Claim getClaimFromToken(String token, String from){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim(from);
    }
    public boolean validateToken(String token){
        try{
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
            verifier.verify(token);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }
}

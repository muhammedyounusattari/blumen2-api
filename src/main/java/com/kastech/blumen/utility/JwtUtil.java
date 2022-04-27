package com.kastech.blumen.utility;

import com.kastech.blumen.model.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import static com.kastech.blumen.constants.SecurityConstants.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtUtil {

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractKeyFromToken(String token, String key) {
        return extractClaim(token, key);
    }


    private String extractClaim(String token, String key) {
        final Claims claims = extractAllClaims(token);
        return claims.get(key)!=null?""+claims.get(key):"";
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    public String generateToken(Authentication authentication, CustomUserDetails customUserDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(authentication,claims, customUserDetails);
    }


    private String createToken(Authentication authentication, Map<String, Object> claims, CustomUserDetails user) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return
        Jwts.builder()
                .setIssuer(user.getUsername())
                .setSubject(user.getEmail())
               // .claim(AUTHORITIES, authorities)
                .claim("orgCode", user.getOrgCode())
                .claim("orgId", user.getOrgId())
                .claim("email", user.getEmail())
                .claim("scope", user.getScope())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
package com.bookstore_member.megabookstore_member.jwt;
//토큰 관련 설정 담당 클래스
//토큰 발급 및 자격증명 관리
import com.bookstore_member.megabookstore_member.domain.member.Role;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    @Value("${spring.jwt.secret}")
    private String secretKey;
    @Value("${spring.jwt.expiretime}")
    private final long expireTime;

    private final UserDetailsService userDetailsService;


    // jwt token 으로부터 username 획득
    public static String getUserName(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().get("userName", String.class);

    }

    // jwt token 으로부터 만료일자 알려줌
    public static boolean isExpired(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody().getExpiration().before(new Date());     //data 형식

    }

    public String CreateJWT(String username, Set<Role> roles) {
        Claims claims = Jwts.claims().setSubject(username);  // jwt payload 에 저장되는 정보단위
        claims.put("roles", roles);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)  //정보저장
                .setIssuedAt(now)   //토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + expireTime))      //set expire time
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 토큰으로 받은 정보를 기반으로 Authentication 객체 반환 메소드
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // request 의 header 에서 token 값을 가져옴
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("authorization");
    }

    // 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String accessToken) {
        if (accessToken == null) {
            return false;
        }
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(accessToken)
                    .getBody()
                    .getExpiration()
                    .after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private String getUsername(String accessToken) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(accessToken)
                .getBody()
                .getSubject();
    }

    public String createJWT(String id, String secretKey, long expire) {
        return createJWT(id, secretKey, expire);
    }
}

package com.bookstore_member.megabookstore_member.jwt;

import com.bookstore_member.megabookstore_member.domain.converter.BooleanToYNConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class JwtUtilTest {


    private JwtUtil jwtUtil;

    private final String secretKey = "asdasdasdasdasdasdasdasdasdasdsadasdasdasaa";

    private long expire = 60 * 24 * 30;


    @BeforeEach
    public void testBefore() {

        System.out.println("testBefore......................");
        jwtUtil = new JwtUtil();


    }

    @Test
    public void testEncode() throws Exception {

        String id = "twtwtw8282";

        String jwt = jwtUtil.createJWT(id, secretKey, expire);

        System.out.println(jwt);


    }



}
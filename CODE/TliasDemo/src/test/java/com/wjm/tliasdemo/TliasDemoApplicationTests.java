package com.wjm.tliasdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasDemoApplicationTests {

    @Test
    void contextLoads() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String s = Arrays.toString(a);
        System.out.println(s.substring(1, s.length() - 1));
    }


    /*
     * jwt令牌生成
     * */
    @Test
    void generateJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "wuyi");
        // 生成一个安全的密钥
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwt = Jwts.builder()
                .signWith(key)//签名算法
                .setClaims(claims)//自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期
                .compact();
        System.out.println(jwt);
    }

    /*
     * jwt令牌解析
     * */
    @Test
    void parseJwt(String jwt, SecretKey key) {
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }

}

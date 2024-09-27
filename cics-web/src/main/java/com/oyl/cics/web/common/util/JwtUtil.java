package com.oyl.cics.web.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum JwtUtil {
    instance;

    private static final String PWD = "12345";
    private static final int EXPIRY_HOURS = 24;

    private static final Algorithm algorithm = Algorithm.HMAC256(PWD);

    /**
     * 生成JWT token
     * @param username 用户登录账号
     * @return JWT token
     */
    public String createToken(String username) {
        Map<String, Object> params = new HashMap<>();
        params.put("alg", "HS256");
        params.put("typ", "JWT");
        Date now = new Date();

        return JWT.create()
                .withHeader(params)
                .withClaim("username", username)
                .withIssuedAt(now)
                .withExpiresAt(new Date(now.getTime() + 1000 * 3600 * EXPIRY_HOURS))
                .sign(algorithm);
    }

    /**
     * 验证JWT token
     *
     * @param token JWT token
     * @return 验证通过返回用户登录账号
     * @throws JWTVerificationException 验证失败时抛JWTVerificationException异常
     */
    public String verify(String token) {
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
        return decodedJWT.getClaims().get("username").asString();
    }

    /*public static void main(String[] args) {
        String token = JwtUtil.instance.createToken("OYL");
        System.out.println(token);
        String result = JwtUtil.instance.verify(token);
        System.out.println(result);

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("after sleep::");
        System.out.println(JwtUtil.instance.verify(token));
    }*/
}

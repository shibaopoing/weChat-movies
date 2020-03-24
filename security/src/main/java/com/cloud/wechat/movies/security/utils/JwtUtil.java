package com.cloud.wechat.movies.security.utils;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.alibaba.fastjson.JSONObject;

import com.cloud.wechat.movies.security.constant.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    // token秘钥  太短会报错
    public static String SECRET = "qwerasdfdxzvdfajjlkjeiojznvxndjkfaowijeiodldsxxccasdffgfhfgfcvbfedggfffssda1615316541615121315131315151asda";

    /**
     * 生成Jwt的方法
     *
     * @param id
     *            用户ID
     * @param subject
     *            用户昵称
     * @param ttlMillis
     *            过期时间
     * @return Token String 凭证
     */
    public static String createJWT(String id, String subject) {
        // 签名方法 HS256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成Jwt的时间
        //long nowMillis = System.currentTimeMillis();
       // Date now = new Date(nowMillis);
        LocalDateTime currentTime = LocalDateTime.now();
        // 生成秘钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // 设置JWT所存储的信息
        JwtBuilder builder = Jwts.builder().
                setId(id).
                setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant())).
                setExpiration(Date.from(currentTime.plusMinutes(SecurityConstant.tokenExpirationTime).
                        atZone(ZoneId.systemDefault()).toInstant())).
                setIssuer(SecurityConstant.tokenIssuer).
                setSubject(subject).
                signWith(signingKey, signatureAlgorithm);

        //builder.claim("name", "value"); //存储自定义信息

        // 设置过期时间
/*        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }*/
        // 构建JWT并将其序列化为紧凑的URL安全字符串
        return builder.compact();
    }

    /**
     * 解析Jwt字符串
     *
     * @param jwt
     *            Jwt字符串
     * @return Claims 解析后的对象
     */
    public static Claims parseJWT(String jwt) {
        return Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET)).build().parseClaimsJws(jwt).getBody();
    }

    /**
     * 验证JWT
     *
     * @param jwtStr jwt字符串
     * @return JOSNObject 解析结果<br/>
     *         &emsp;&emsp;Success 成功标识<br/>
     *         &emsp;&emsp;&emsp;&emsp;true：成功<br/>
     *         &emsp;&emsp;&emsp;&emsp;false：失败<br/>
     *         &emsp;&emsp;Claim 声明对象<br/>
     *         &emsp;&emsp;ErrCode 错误码<br/>
     *         &emsp;&emsp;&emsp;&emsp;1005：过期<br/>
     *         &emsp;&emsp;&emsp;&emsp;1004：未登录
     */
    public static JSONObject validateJWT(String jwtStr) {
        JSONObject pojo = new JSONObject();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            pojo.put("Success", true);
            pojo.put("Claims", claims);
        } catch (ExpiredJwtException e) {
            pojo.put("Success", false);
            pojo.put("ErrCode", 1005);
            e.printStackTrace();
        } catch (Exception e) {
            pojo.put("Success", false);
            pojo.put("ErrCode", 1004);
            e.printStackTrace();
        }
        return pojo;
    }
}



package com.cloud.wechat.movies.security.utils;

import com.alibaba.fastjson.JSON;
import com.cloud.wechat.movies.security.constant.SecurityConstant;
import com.cloud.wechat.movies.security.entity.RoleInfo;
import com.cloud.wechat.movies.security.pojo.AuthUserDetails;
import com.cloud.wechat.movies.security.pojo.Scopes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @ClassName TokenUtil
 * @Description token工具类
 * @Author liuheming
 * @Date 2019/4/12 9:46
 * @Version 1.0
 **/
@Component
public class TokenUtil<main> {
    /**
     * @Author liuheming
     * @Description 生成新的token方法，并将角色保存
     * @Date 17:18 2019/5/6
     * @Param [authUserDetails]
     * @return AccessJwtToken
     **/
    public String createAccessJwtToken(AuthUserDetails authUserDetails) {
        if (StringUtils.isBlank(authUserDetails.getUsername())) {
            throw new IllegalArgumentException("用户名为空无法创建token");
        }

        Claims claims = Jwts.claims().setSubject(authUserDetails.getUsername());

        //存入角色信息
        List<String> list=new ArrayList<>();
        for (RoleInfo roleInfo:authUserDetails.getRoleInfos()) {
            list.add(roleInfo.getId());
        }

        claims.put(SecurityConstant.AUTHORITIES, JSON.toJSONString(list));

        LocalDateTime currentTime = LocalDateTime.now();
        Key key = getPrivateKey(SecurityConstant.tokenSigningKey);
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(SecurityConstant.tokenIssuer)
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(SecurityConstant.tokenExpirationTime)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();

        return token;
    }

    /**
     * @Author liuheming
     * @Description 创建刷新token
     * @Date 17:39 2019/5/6
     * @Param [authUserDetails]
     * @return com.lhm.springcloud.security.pojo.JwtToken
     **/
    public String createRefreshToken(AuthUserDetails authUserDetails) {
        if (StringUtils.isBlank(authUserDetails.getUsername())) {
            throw new IllegalArgumentException("用户名为空无法创建token");
        }

        LocalDateTime currentTime = LocalDateTime.now();

        Claims claims = Jwts.claims().setSubject(authUserDetails.getUsername());
        claims.put(SecurityConstant.AUTHORITIES, Arrays.asList(Scopes.REFRESH_TOKEN.authority()));
        Key key = getPrivateKey(SecurityConstant.tokenSigningKey);
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(SecurityConstant.tokenIssuer)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(SecurityConstant.refreshTokenExpTime)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key,SignatureAlgorithm.HS512)
                .compact();

        return token;
    }
    /** * 解码PublicKey * @param key * @return */
    public static PublicKey getPublicKey(String key)
    {
        try {
            byte[] byteKey = Base64.getDecoder().decode(key);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
   /** * 解码PrivateKey * @param key * @return */
   public static Key getPrivateKey(String key) {
       try {
           SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
           // 生成秘钥
           byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
           Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
           return signingKey;
       } catch (Exception e) {
           e.printStackTrace();
       }    return null;
   }
    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "NTQ1NjQ2NTRkc2Y0c2Q0ZnNkZnNkNTZmNHNkNTY0ZjU2c2RmNNTQ1NjQ2NTRkc2Y0c2Q0ZnNkZnNkNTZmNHNkNTY0ZjU2c2RmN";
        String res = Base64.getEncoder().encodeToString(str.getBytes());
       System.out.println(res);
    }
}

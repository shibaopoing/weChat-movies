package com.cloud.wechat.movies.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {
    public static void main(String[] args) {
        String pass = "12345";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);

        boolean f = bcryptPasswordEncoder.matches("12345",hashPass);
        System.out.println(f);

    }
}

package com.cloud.wechat.movies;

import com.cloud.wechat.movies.security.utils.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication  //启动自动扫描 加载配置类
@MapperScan("com.cloud.wechat.movies.security.mapper")
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SecurityApplication.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        // 将Context设置到SpringUtil中
        SpringUtil.setApplicationContext(configurableApplicationContext);
    }

}

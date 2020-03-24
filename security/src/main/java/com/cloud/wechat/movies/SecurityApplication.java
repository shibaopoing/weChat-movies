package com.cloud.wechat.movies;

import com.cloud.wechat.movies.security.utils.SpringUtil;
import com.cloud.wechat.movies.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication  //启动自动扫描 加载配置类
@MapperScan("com.cloud.wechat.movies.security.mapper")
public class SecurityApplication {

/*    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SecurityApplication.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        // 将Context设置到SpringUtil中
        SpringUtil.setApplicationContext(configurableApplicationContext);
    }*/
@Bean
public SpringUtils getSpringUtils(){
    return new SpringUtils();
}
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}

package com.cloud.wechat.movies;

import com.cloud.wechat.movies.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication  //启动自动扫描 加载配置类
@EnableScheduling  //定时任务扫描
@EnableAsync //开启异步任务
@MapperScan("com.cloud.wechat.movies.movie.dao")   //扫描mapper路径
@EnableFeignClients
@EnableDiscoveryClient
public class MovieApplication {
    @Bean
    public SpringUtils getSpringUtils(){
        return new SpringUtils();
    }
    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);
    }

}

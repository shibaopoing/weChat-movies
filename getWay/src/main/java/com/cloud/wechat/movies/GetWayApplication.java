package com.cloud.wechat.movies;

import com.cloud.wechat.movies.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  //启动自动扫描 加载配置类
@EnableDiscoveryClient
public class GetWayApplication {
   @Bean
    public SpringUtils getSpringUtils(){
        return new SpringUtils();
    }
    public static void main(String[] args) {
        SpringApplication.run(GetWayApplication.class, args);
    }

}

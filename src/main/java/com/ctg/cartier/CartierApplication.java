package com.ctg.cartier;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableConfigurationProperties
@EnableScheduling
@EnableAsync
@MapperScan("com.ctg.cartier.dao")
@SpringBootApplication
public class CartierApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartierApplication.class, args);
    }

}

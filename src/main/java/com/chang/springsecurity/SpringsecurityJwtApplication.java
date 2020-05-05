package com.chang.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.chang.springsecurity.mapper")
public class SpringsecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityJwtApplication.class, args);
    }

}

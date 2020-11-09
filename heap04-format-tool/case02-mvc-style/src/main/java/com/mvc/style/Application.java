package com.mvc.style;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(value = "com.mvc.style.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args) ;
    }
}

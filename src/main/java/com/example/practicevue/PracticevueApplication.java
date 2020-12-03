package com.example.practicevue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.example.practicevue.mapper"})
public class PracticevueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticevueApplication.class, args);
    }

}

package com.example.Web_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.example.Web_prac")
public class WebPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebPracApplication.class, args);
	}

}

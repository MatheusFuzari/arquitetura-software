package com.example.xesqye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class XesqyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(XesqyeApplication.class, args);
	}

}

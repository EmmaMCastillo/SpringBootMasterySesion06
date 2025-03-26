package com.tdx.sesion06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Sesion06Application {

	public static void main(String[] args) {
		SpringApplication.run(Sesion06Application.class, args);
	}

}

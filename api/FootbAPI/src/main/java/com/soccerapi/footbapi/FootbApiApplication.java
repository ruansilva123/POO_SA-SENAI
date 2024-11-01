package com.soccerapi.footbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FootbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootbApiApplication.class, args);
	}

	@GetMapping("teste/")
	public String teste(){
		return "Teste2";
	}
}
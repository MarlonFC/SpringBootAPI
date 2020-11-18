package com.api.rest.com.api.rest;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@EntityScan(basePackages = {"com.api.rest.model"}) //mapear as classes de modelo
@ComponentScan(basePackages = {"com.*"}) // injeção de dependencias.
@EnableJpaRepositories(basePackages = {"com.api.rest.repository"}) //habilitar os DAOS e suas interfaces.
@EnableTransactionManagement //controle de transações no banco de dados.
@EnableWebMvc //ativar recursos MVC
@RestController //informar que é um projeto REST
@EnableAutoConfiguration //spring configurará todo o projeto.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
				
	
		
		
		
	}

}

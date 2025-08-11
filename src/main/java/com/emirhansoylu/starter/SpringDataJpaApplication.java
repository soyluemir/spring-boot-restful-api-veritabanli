package com.emirhansoylu.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

 
@SpringBootApplication
@EntityScan(basePackages = {"com.emirhansoylu"})// bu paketler altıdna entitymi tara
@ComponentScan(basePackages = {"com.emirhansoylu"}) //oluşturduğum beanleri arıyor controller gibi
@EnableJpaRepositories(basePackages =  {"com.emirhansoylu"}) //jpa repository  interfacesi görmesi için
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}

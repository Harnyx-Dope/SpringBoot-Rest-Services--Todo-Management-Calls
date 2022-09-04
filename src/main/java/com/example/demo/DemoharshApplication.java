package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example.*")
@EntityScan("com.example.demo.Entity")
@EnableJpaRepositories("com.example.demo.StudentRepostitory")
public class DemoharshApplication 
{

	public static void main(String[] args)
	{
		 
		SpringApplication.run(DemoharshApplication.class, args);
	}

}

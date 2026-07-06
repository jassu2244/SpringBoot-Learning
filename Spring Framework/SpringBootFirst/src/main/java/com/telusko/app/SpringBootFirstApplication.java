package com.telusko.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootFirstApplication.class, args);
		
//Main is dependent on Alien object and Alien is dependent on laptop object, to give context to each other we
//used @Component annotation and @AutoWired to give context to each other and create an object(bean) inside spring container
		
		Alien obj = context.getBean(Alien.class); // this means we are telling spring to create an object
		obj.code();
	}
}

package com.telusko.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//this annotation is used to tell the spring framework that create an object for this component
@Component 
public class Alien {
	
	@Value("25")
	private int age;

	private Computer com;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Computer getCom() {
		return com;
	}

	// this is called wiring, this means it will search for this component inside this spring project
	@Autowired
	@Qualifier("laptop")
	public void setCom(Computer com) {
		this.com = com;
	}

	public void code() {
		com.compile();
	}
}

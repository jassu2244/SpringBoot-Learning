package com.telusko.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//this annotation is used to tell the spring framework that create an object for this component
@Component 
public class Alien {
	
	// this is called wiring, this means it will search for this component inside this spring project
	@Autowired
	Laptop laptop;
	
	public void code() {
		laptop.compile();
		
	}
}

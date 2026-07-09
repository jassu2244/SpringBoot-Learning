package com.telusko.app.repo;

import org.springframework.stereotype.Repository;

import com.telusko.app.model.Laptop;

@Repository // same as adding @Component so this is used to do Domain Driven Design
public class LaptopRepository {
	
	public void save(Laptop lap) {
		System.out.println("Saved in Database");
	}
}

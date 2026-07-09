package com.telusko.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.app.model.Laptop;
import com.telusko.app.repo.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository repo;
	
	public void addLaptop(Laptop lap) {
		repo.save(lap);
//		System.out.println("Method called");
	}
	
	public boolean isGoodForProg(Laptop lap) {
		return true;
	}
}

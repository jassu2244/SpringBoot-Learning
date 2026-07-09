package com.telusko;

import org.springframework.stereotype.Component;

@Component //this annotation tells this class that it is managed by spring so using this we don't need AppConfig file
public class Laptop implements Computer {

    public Laptop() {
        System.out.println("Laptop class created");
    }

    @Override
    public void compile() {
        System.out.println("Compiling using Laptop");
    }
}

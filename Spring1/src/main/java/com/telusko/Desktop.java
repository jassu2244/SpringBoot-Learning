package com.telusko;

import org.springframework.stereotype.Component;

@Component("com2") //this annotation tells this class that it is managed by spring so using this we don't need AppConfig file
public class Desktop implements Computer{

    public Desktop() {
        System.out.println("Desktop Object Created");
    }
    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}

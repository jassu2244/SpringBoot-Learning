package com.telusko;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("com2") //this annotation tells this class that it is managed by spring so using this we don't need AppConfig file
@Primary //making one class primary like this solves that 2 bean error so it will prefer this one, but still if mentioned @Qualifier
//it will still prefer Qualifier above primary
@Scope("prototype")
public class Desktop implements Computer{

    public Desktop() {
        System.out.println("Desktop Object Created");
    }
    @Override
    public void compile() {
        System.out.println("Compiling using Desktop");
    }
}

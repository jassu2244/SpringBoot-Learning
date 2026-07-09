package com.telusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component // this annotation tells this class that it is managed by spring so using this we don't need AppConfig file
//right now we are creating this alien object, but it is not able to find this age and com values because there is no wiring between
//computer class and alien class, so spring framework is creating age and com with default value where age = 0 and com = null
//and to tell spring to search for this com object or Computer class, we use @Autowired annotation
//so it tells container to scan and get the object
public class Alien {

    private int age;
//    private Laptop lap;

    @Autowired
    @Qualifier("laptop") // inside this qualifier we need to specify the bean name where in AppConfig file it was method name
    //here bean name is Class name with small letter so for Laptop(class) we have to mention "laptop"
    private Computer com;

    public Alien() {
//        System.out.println("Object created");
    }

    // this annotation helps to remove that sequence problem while assigning the value, so if this annotation is here
    //it will not give sequence problem while using name in constructor-arg
//    @ConstructorProperties({"age", "lap"})
//    public Alien(int age, Laptop lap) {
//        System.out.println("Para constructor called"); // this is happening because we passed the value in xml file using constructor-arg
//        this.age = age;
//        this.lap = lap;
//    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        System.out.println("Setter called");
        this.age = age;
    }

//    public Laptop getLap() {
//        return lap;
//    }
//
//
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public void code() {
        System.out.println("Coding");
//        lap.compile();
        com.compile();
    }
}

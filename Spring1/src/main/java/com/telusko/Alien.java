package com.telusko;

import java.beans.ConstructorProperties;

public class Alien {

    private int age;
    private Laptop lap;

    public Alien() {
        System.out.println("Object created");
    }

    // this annotation helps to remove that sequence problem while assigning the value, so if this annotation is here
    //it will not give sequence problem while using name in constructor-arg
    @ConstructorProperties({"age", "lap"})
    public Alien(int age, Laptop lap) {
        System.out.println("Para constructor called"); // this is happening because we passed the value in xml file using constructor-arg
        this.age = age;
        this.lap = lap;
    }

    public void code() {
        System.out.println("Coding");
        lap.compile();
    }

    public int getAge() {
        return age;
    }

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public void setAge(int age) {
        System.out.println("Setter called");
        this.age = age;
    }
}

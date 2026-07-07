package com.telusko;

public class Alien {

    private int age;
    private Laptop lap;

    public Alien() {
        System.out.println("Object created");
    }

    public Alien(int age) {
        this.age = age;
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

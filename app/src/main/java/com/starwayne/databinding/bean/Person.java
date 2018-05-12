package com.starwayne.databinding.bean;


import java.util.Random;

public class Person {
    private String name;
    private String age;
    private String country;
    private boolean isMale;

    public Person() {
    }

    public Person(String name, String age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        Random random = new Random(System.currentTimeMillis());
        this.isMale = random.nextBoolean();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isMale() {
        return isMale;
    }

}

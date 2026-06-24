package com.example.week8likelion.domain;

public class BabyLion {

    private Long id;
    private String name;
    private int age;
    private String part;

    public BabyLion(Long id, String name, int age, String part){
        this.id = id;
        this.name = name;
        this.age = age;
        this.part = part;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPart(){
        return part;
    }

    public void update(String name, int age, String part) {
        this.name = name;
        this.age = age;
        this.part = part;
    }
}


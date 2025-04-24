package com.jaime.practices.practices1.qualifiers;

public abstract class Animal {

    private String name;
    private String age;

    public Animal(String name, String age){
        this.name = name;
        this.age = age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name ){
        this.name = name;
    }

    public String getAge(){
        return this.age;
    }

    public void setAge(String age){
        this.age = age;
    }
}

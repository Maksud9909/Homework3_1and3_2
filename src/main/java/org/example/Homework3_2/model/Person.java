package org.example.Homework3_2.model;
import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person{
    private String name;
    private int age;
    private List<String> hobbies;
    private Map<String, String> family;

    public Person()
    {
        setHobbies(new ArrayList<>());
        setFamily(new HashMap<>());
    }

    public Person(String name, int age, List<String> hobbies, Map<String, String> family)
    {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.family = family;
    }
    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if(!hobbies.isEmpty()) System.out.println("Hobbies: " + hobbies.toString());
        if(!family.isEmpty()) System.out.println("Family: " + family.toString());
    }





}
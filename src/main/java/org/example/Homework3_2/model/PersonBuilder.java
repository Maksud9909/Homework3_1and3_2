package org.example.Homework3_2.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public final class PersonBuilder {
    private final String name;
    private final int age;
    private final List<String> hobbies;
    private final Map<String, String> family;

    public static Person getJohn() {
        return new Person("John", 55, toList("Workout", "Fishing"),
                createFamilyMap("wife", "Mrs John", "son", "David", "daughter", "Margaret"));
    }

    public static Person getBob() {
        return new Person("Bob", 30, toList("Basketball", "Workout"),
                createFamilyMap("wife", "Mrs Bob", "son", "Chris"));
    }

    public static Person getAnthony() {
        return new Person("Anthony", 30, toList("Drawing", "Cycling", "Swimming"),
                createFamilyMap("wife", "Mrs Anthony", "son", "Paul", "daughter", "Paul"));
    }

    public static Person getArnold() {
        return new Person("Arnold", 30, toList("Workout", "Acting", "Swimming"), createFamilyMap());
    }

    public static Person getTom() {
        return new Person("Tom", 30, toList("Eating", "Sleeping", "Walking"), createFamilyMap());
    }

    public static Person getCat() {
        return new Person("Cat", 30, toList("Eating", "Sleeping", "Walking"), createFamilyMap());
    }

    private static List<String> toList(String... hobbies) {
        return Stream.of(hobbies).collect(Collectors.toList());
    }

    private static Map<String, String> createFamilyMap(String... entries) {
        Map<String, String> family = new HashMap<>();
        if (entries.length % 2 != 0) {
            throw new IllegalArgumentException("Number of entries must be even");
        }
        for (int i = 0; i < entries.length; i += 2) {
            family.put(entries[i], entries[i + 1]);
        }
        return family;
    }
}

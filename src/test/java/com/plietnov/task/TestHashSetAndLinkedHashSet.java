package com.plietnov.task;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestHashSetAndLinkedHashSet {

    private Map<KeyHashLength, Integer> hashMapLength = new HashMap<>();
    private Map<KeyHashSum, Integer> hashMapSum = new HashMap<>();
    private Map<KeyHashLength, Integer> linkedHashMapLength = new LinkedHashMap<>();
    private Map<KeyHashSum, Integer> linkedHashMapSum = new LinkedHashMap<>();

    @Before
    public void init() {
        hashMapLength.put(new KeyHashLength("he="), 1);
        hashMapLength.put(new KeyHashLength("hel="), 2);
        hashMapLength.put(new KeyHashLength("hello="), 3);
        hashMapSum.put(new KeyHashSum("hello="), 1);
        hashMapSum.put(new KeyHashSum("test="), 2);
        hashMapSum.put(new KeyHashSum("abcd="), 3);
        linkedHashMapLength.put(new KeyHashLength("he="), 1);
        linkedHashMapLength.put(new KeyHashLength("hel="), 2);
        linkedHashMapLength.put(new KeyHashLength("hello="), 3);
        linkedHashMapSum.put(new KeyHashSum("hello="), 1);
        linkedHashMapSum.put(new KeyHashSum("test="), 2);
        linkedHashMapSum.put(new KeyHashSum("abcd="), 3);
    }

    @Test
    public void testHashMap() {
        System.out.println("hashMapLength");
        hashMapLength.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("hashMapSum");
        hashMapSum.forEach((key, value) -> System.out.println(key + " - " + value));

    }

    @Test
    public void testLinkedHashMap() {
        System.out.println("linkedHashMapLength");
        linkedHashMapLength.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println("linkedHashMapSum");
        linkedHashMapSum.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}

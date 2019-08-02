package com.plietnov.task;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SetArrayListTest {
    private List<KeyHashLength> testListLength = new SetArrayList<>();
    private List<KeyHashSum> testListSum = new SetArrayList<>();

    @Before
    public void beforeTest() {
        testListLength.add(new KeyHashLength("a" + 1000));
        testListLength.add(new KeyHashLength("b" + 1000));
        testListLength.add(new KeyHashLength("c" + 1000));
        testListLength.add(new KeyHashLength("d" + 1000));
        testListLength.add(new KeyHashLength("e" + 1000));
        testListSum.add(new KeyHashSum("a" + 2000));
        testListSum.add(new KeyHashSum("b" + 2000));
        testListSum.add(new KeyHashSum("c" + 2000));
        testListSum.add(new KeyHashSum("d" + 2000));
        testListSum.add(new KeyHashSum("e" + 2000));
    }

    @Test
    public void add_AddKeyHashLengthToList_ShouldAddElement() {
        testListLength.add(new KeyHashLength("TestElement"));
        assertTrue(testListLength.contains(new KeyHashLength("TestElement")));
    }

    @Test
    public void add_AddKeyHashSumToList_ShouldAddElement() {
        testListSum.add(new KeyHashSum("TestElement"));
        assertTrue(testListSum.contains(new KeyHashSum("TestElement")));
    }

    @Test
    public void add_AddKeyHashLengthToListByIndex_ShouldAddElement() {
        testListLength.add(0, new KeyHashLength("TestElement"));
        assertEquals(0, testListLength.indexOf(new KeyHashLength("TestElement")));
    }

    @Test
    public void add_AddKeyHashSumToListByIndex_ShouldAddElement() {
        testListSum.add(0, new KeyHashSum("TestElement"));
        assertEquals(0, testListSum.indexOf(new KeyHashSum("TestElement")));
    }

    @Test
    public void addAll_AddKeyHashLengthToList_ShouldAddElement() {
        List<KeyHashLength> list = new ArrayList<>();
        list.add(new KeyHashLength("firstKey"));
        list.add(new KeyHashLength("secondKey"));
        assertTrue(testListLength.addAll(list));
    }

    @Test
    public void addAll_AddKeyHashSumToList_ShouldEddElement() {
        List<KeyHashSum> list = new ArrayList<>();
        list.add(new KeyHashSum("firstKey"));
        list.add(new KeyHashSum("secondKey"));
        assertTrue(testListSum.addAll(list));
    }

    @Test
    public void addAll_AddKeyHashLengthToListByIndex_ShouldEddElement() {
        List<KeyHashLength> list = new ArrayList<>();
        list.add(new KeyHashLength("firstKey"));
        list.add(new KeyHashLength("secondKey"));
        assertTrue(testListLength.addAll(0, list));
    }

    @Test
    public void addAll_AddKeyHashSumToListByIndex_ShouldEddElementAndIncreaseSize() {
        List<KeyHashSum> list = new ArrayList<>();
        list.add(new KeyHashSum("firstKey"));
        list.add(new KeyHashSum("secondKey"));
        assertTrue(testListSum.addAll(0, list));
    }

    @Test
    public void set_SetKeyHashSumToList_ShouldSetElementByIndex() {
        KeyHashSum testSetElement = new KeyHashSum("TestElement");
        testListSum.set(0, testSetElement);
        assertTrue(testListSum.contains(new KeyHashSum("TestElement")));
    }

    @Test
    public void set_SetKeyHashLengthToList_ShouldSetElementByIndex() {
        KeyHashLength testSetElement = new KeyHashLength("TestElement");
        testListLength.set(0, testSetElement);
        assertEquals(testSetElement, testListLength.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_AddKeyHashLengthToList_IllegalArgumentException() {
        testListLength.add(new KeyHashLength("TestElement"));
        testListLength.add(new KeyHashLength("TestElement"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_AddKeyHashSumToList_IllegalArgumentException() {
        testListSum.add(new KeyHashSum("TestElement"));
        testListSum.add(new KeyHashSum("TestElement"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_AddKeyHashLengthToListByIndex_IllegalArgumentException() {
        testListLength.add(0, new KeyHashLength("TestElement"));
        testListLength.add(0, new KeyHashLength("TestElement"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void add_AddKeyHashSumToListByIndex_IllegalArgumentException() {
        testListSum.add(0, new KeyHashSum("TestElement"));
        testListSum.add(0, new KeyHashSum("TestElement"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_SetKeyHashSumToList_IllegalArgumentException() {
        KeyHashSum testSetElement = new KeyHashSum("TestElement");
        testListSum.set(0, testSetElement);
        testListSum.set(2, testSetElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_SetKeyHashLengthToList_IllegalArgumentException() {
        KeyHashLength testSetElement = new KeyHashLength("TestElement");
        testListLength.set(0, testSetElement);
        testListLength.set(2, testSetElement);
    }
}

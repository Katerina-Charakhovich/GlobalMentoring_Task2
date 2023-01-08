package com.epam.effective.java.util;

import com.epam.effective.java.util.sort.InsertionSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertionSortTest {
    @Test
    public void insertionSortTest() {
        int[] testData = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = InsertionSort.sort(testData);
        Assert.assertTrue(Arrays.equals(expected,actual));
    }
}
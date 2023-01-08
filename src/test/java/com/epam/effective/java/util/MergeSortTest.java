package com.epam.effective.java.util;

import com.epam.effective.java.util.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    public void mergeSortTest() {
        int[] testData = {5, 1, 6, 2, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] actual = MergeSort.sort(testData);
        Assert.assertTrue(Arrays.equals(expected,actual));
    }
}
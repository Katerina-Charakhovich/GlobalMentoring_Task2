package com.epam.effective.java.util;

import com.epam.effective.java.util.search.Search;
import org.junit.Assert;
import org.junit.Test;



public class SearchTest {
    @Test
    public void binarySearchIterative() {
        int[] testData = {1, 2, 6, 8, 10, 12, 14, 15, 17, 19};
        Assert.assertEquals(4, Search.binarySearchIterative(testData,10));
    }
    @Test
    public void binarySearchRecursive() {
        int[] testData = {14, 15, 17, 19, 1, 2, 6, 8, 10, 12};
        Assert.assertEquals(4,Search.binarySearchIterative(testData,10));
    }

}
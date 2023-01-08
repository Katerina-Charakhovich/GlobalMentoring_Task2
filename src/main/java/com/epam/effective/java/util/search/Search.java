package com.epam.effective.java.util.search;

import com.epam.effective.java.util.sort.InsertionSort;

import java.util.Arrays;

public class Search {

    public static int binarySearchIterative(int[] elements, int searchElement) {
        return binarySearchIterativeAlgorithm(InsertionSort.sort(elements), searchElement);
    }

    public static int binarySearchRecursive(int[] elements, int searchElement) {
        return binarySearchRecursiveAlgorithm(InsertionSort.sort(elements), searchElement);
    }

    private static int binarySearchIterativeAlgorithm(int[] elements, int searchElement){
        int lowIndex = 0;
        int highIndex = elements.length - 1;
        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            if (searchElement == elements[middleIndex]) {
                return middleIndex;
            } else if (searchElement < elements[middleIndex]) {
                highIndex = middleIndex - 1;
            } else {
                lowIndex = middleIndex + 1;
            }
        }
        return -1;
    }
    private static int binarySearchRecursiveAlgorithm(int[] elements, int searchElement) {
        int lowIndex = 0;
        int highIndex = elements.length - 1;
        int middleIndex = (lowIndex + highIndex) / 2;
        if (searchElement == elements[middleIndex]) {
            return middleIndex;
        } else if (searchElement < elements[middleIndex]) {
            binarySearchRecursive(Arrays.copyOfRange(elements, 0, middleIndex - 1), searchElement);
        } else {
            binarySearchRecursive(Arrays.copyOfRange(elements, middleIndex + 1, highIndex), searchElement);
        }
        return -1;
    }
}

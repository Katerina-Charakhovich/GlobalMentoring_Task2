package com.epam.effective.java.util.sort;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static int[] sort(int[] elements) {
        int size = elements.length;
        if (size == 1) return elements;
        int middleSize = size / 2;
        int[] leftArray = Arrays.copyOf(elements, middleSize);
        int[] rightArray = Arrays.copyOfRange(elements, middleSize , size);

        leftArray = sort(leftArray);
        rightArray = sort(rightArray);

        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        List<Integer> mergeList = new ArrayList();
        List<Integer> rightList = Arrays.stream(rightArray).boxed().collect(Collectors.toList());
        List<Integer> leftList = Arrays.stream(leftArray).boxed().collect(Collectors.toList());
        while (rightList.size() > 0 && leftList.size() > 0) {
            if (leftList.get(0) > rightList.get(0)) {
                mergeList.add(rightList.get(0));
                rightList.remove(0);
            } else {
                mergeList.add(leftList.get(0));
                leftList.remove(0);
            }
        }
        while (leftList.size() > 0) {
            mergeList.add(leftList.get(0));
            leftList.remove(0);
        }
        while (rightList.size() > 0) {
            mergeList.add(rightList.get(0));
            rightList.remove(0);
        }

        return mergeList.stream().mapToInt(i -> i).toArray();
    }

}

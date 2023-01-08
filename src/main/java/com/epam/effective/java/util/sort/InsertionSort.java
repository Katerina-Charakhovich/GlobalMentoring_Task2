package com.epam.effective.java.util.sort;

public class InsertionSort {

    public static int[] sort(int[] elements) {
        int holePosition;
        int valueToInsert;

        if (elements.length==1){
            return elements;
        }
        for (int i = 1; i < elements.length; i++) {
            valueToInsert = elements[i];
            holePosition = i;

            while (holePosition > 0 && elements[holePosition - 1] > valueToInsert) {
                elements[holePosition] = elements[holePosition - 1];
                holePosition = holePosition - 1;
            }
            elements[holePosition] = valueToInsert;
        }
        return elements;
    }

}

package com.epam.effective.java.benchmark;

import com.epam.effective.java.util.sort.InsertionSort;
import com.epam.effective.java.util.sort.MergeSort;
import com.epam.effective.java.util.search.Search;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int binarySearchIterativeTest() {
        int[] testData = {14, 15, 17, 19, 1, 2, 6, 8, 10, 12};
      //  int[] testData = new Random().ints(10,1,11).toArray();;
     //   System.out.println(testData);
        return Search.binarySearchIterative(testData, 10);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int[] mergeSortTest() {
       // int[] testData = new Random().ints(10,1,11).toArray();
        int[] testData = {14, 15, 17, 19, 1, 2, 6, 8, 10, 12};
        return MergeSort.sort(testData);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public int[] insertionSortTest() {
        int[] testData = {14, 15, 17, 19, 1, 2, 6, 8, 10, 12};
        //  int[] testData = new Random().ints(10,1,11).toArray();;
        //   System.out.println(testData);
        return InsertionSort.sort(testData);
    }
}

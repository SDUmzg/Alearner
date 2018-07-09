package com.alearner.lambda;

import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by mzg on 2018/7/9.
 */
public class StreamStatistics {
    public void mixStatistics(List<Integer> numbers){
        IntSummaryStatistics stats = numbers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        System.out.println("Get Count : " + stats.getCount());
        System.out.println("To String : " + stats.toString());
    }
}

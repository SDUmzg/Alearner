package com.alearner.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzg on 2018/7/9.
 */
public class DistinctCollection {
    public void getMulDistinct(List<Integer> numbers){
        List<Integer> mulNumbers = numbers.stream().map(x->x*x).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, mulNumbers);
    }

    public void getDistinct(List<Integer> numbers){
        List<Integer> distinctNumber = numbers.stream().distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinctNumber);
    }
}

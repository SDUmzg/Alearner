package com.alearner.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mzg on 2018/7/7.
 * Java 8中使用lambda表达式的Map和Reduce示例--Map
 */
public class MapLambda {

    //不使用lambda表达式为每个订单加上12%的税
    public void normalCostTax(List<Integer> costBeforeTax){
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
    }


    //使用lambda表达式为每个订单加上12%的税
    public void caotTaxLambda(List<Integer> costBeforeTax){
        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);

    }

}

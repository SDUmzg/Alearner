package com.alearner.lambda;

import java.util.List;

/**
 * Created by mzg on 2018/7/7.
 */
public class ReduceLambda {

    public void normalReduce(List<Integer> costBeforeTax){
        double total = 0;
        for (Integer cost : costBeforeTax){
            double price = cost + .12*cost;
            total+=price;
        }
        System.out.println(total);
    }

    public void ReduceLambda(List<Integer> costBeforeTax){
        double bill = costBeforeTax.stream().map((cost)->cost+.12*cost).reduce((sum,cost)->sum + cost).get();
        System.out.println(bill);
    }

}

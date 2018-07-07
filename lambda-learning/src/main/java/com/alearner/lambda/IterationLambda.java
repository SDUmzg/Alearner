package com.alearner.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mzg on 2018/7/6.
 */
public class IterationLambda {

    public void normalIteration(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object str : features){
            System.out.println(str);
        }
    }

    public void iterationLambda(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach( n -> System.out.println(n));
    }

}

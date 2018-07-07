package com.alearner.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by mzg on 2018/7/6.
 */
public class PredicateLambda {
    public void filter(List names, Predicate condition){
        for (Object name: names){
            if (condition.test(name.toString())){
                System.out.println(name);
            }
        }
    }
}

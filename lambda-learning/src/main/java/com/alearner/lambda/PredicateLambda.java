package com.alearner.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by mzg on 2018/7/6.
 * 使用lambda表达式和函数式接口Predicate
 */
public class PredicateLambda {

    public void filter(List names, Predicate condition){
        for (Object name: names){
            if (condition.test(name.toString())){
                System.out.println(name);
            }
        }
    }

    public void betterFilter(List names, Predicate condition){
        names.stream().filter((name)->(condition.test(name))).forEach((name)->{
            System.out.println(name);
        });
    }
}

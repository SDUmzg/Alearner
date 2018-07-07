package com.alearner.lambda;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by mzg on 2018/7/7.
 * 如何在lambda表达式中加入Predicate
 */
public class PredicateInLambda {

    public void andFilter(List names){
        Predicate<String> startsWithJ = (n)->n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length()==4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n)->
                    System.out.println("nName, which starts witn \"J\",and four letter long is "+n)
                );
    }

}

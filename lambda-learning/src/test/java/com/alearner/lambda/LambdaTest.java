package com.alearner.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mzg on 2018/7/6.
 */
@SpringBootTest
public class LambdaTest {

    //匿名内部类
    @Test
    public void test1(){
        LambdaRunable lambdaRunable = new LambdaRunable();
        lambdaRunable.beforeLambda();
        lambdaRunable.useLambda();

    }

    //匿名监听器
    @Test
    public void  test2(){
        EventProcess eventProcess = new EventProcess();
        eventProcess.EventListnerAnonymous();
        eventProcess.EventListnerLambda();
    }


    //迭代
    @Test
    public void test3(){
        IterationLambda iterationLambda = new IterationLambda();
        iterationLambda.normalIteration();
        System.out.println("----------------------------------");
        iterationLambda.iterationLambda();
    }

    // Predicate filter
    @Test
    public void test4(){
        PredicateLambda predicateLambda = new PredicateLambda();
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("Languages which starts with J :");
        predicateLambda.filter(languages, (str)->str.toString().startsWith("J"));
        System.out.println("Languages which ends with a ");
        predicateLambda.filter(languages,(str)->str.toString().endsWith("a"));
        System.out.println("Print all languages :");
        predicateLambda.filter(languages,(str)->true);
        System.out.println("Print no language : ");
        predicateLambda.filter(languages,(str)->false);
        System.out.println("Print language whose length greater than 4:");
        predicateLambda.filter(languages,(str)->str.toString().length()>4);
        System.out.println("Print language whose length lee than 4");
        predicateLambda.filter(languages,(str)->str.toString().length()<4);
    }
}
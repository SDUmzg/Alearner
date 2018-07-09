package com.alearner.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzg on 2018/7/9.
 */
public class FunctionLambda {

    public void getFunctionLambda(List<String> countryList){
        String countryStr = countryList.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(countryStr);
    }

}

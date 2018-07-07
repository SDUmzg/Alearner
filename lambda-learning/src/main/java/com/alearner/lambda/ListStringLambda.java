package com.alearner.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mzg on 2018/7/7.
 */
public class ListStringLambda {

    public void getListString(List<String> listStr ){
        List<String> filterStr = listStr.stream().filter((str)->str.length()>2).collect(Collectors.toList());
        System.out.printf("Original List : %s ,filter List : %s %n", listStr,filterStr);
    }

}

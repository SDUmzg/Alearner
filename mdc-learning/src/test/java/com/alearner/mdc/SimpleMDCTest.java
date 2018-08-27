package com.alearner.mdc;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


/**
 * Created by mzg on 2018/8/24.
 */
@SpringBootTest
public class SimpleMDCTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMDCTest.class);

    @Test
    public void MdcTest(){

        System.out.println("test start");

        MDC.put("test","test");

        MDC.put("test1","test1");

        Map<String,String> mdcMap = MDC.getCopyOfContextMap();

        System.out.println("mdcMap : "+ mdcMap.toString());

        MDC.clear();

        Map<String,String> mdcMap1 = MDC.getCopyOfContextMap();

        if (mdcMap1!=null){
            System.out.println("mdcMap1 : "+ mdcMap1.toString());
        }

        MDC.put("test2","test2");

        Map<String,String> mdcMap2 = MDC.getCopyOfContextMap();

        System.out.println("mdcMap2 : "+ mdcMap2.toString());

        MDC.setContextMap(mdcMap);

        Map<String,String> mdcMap3 = MDC.getCopyOfContextMap();

        System.out.println("mdcMap3 : "+ mdcMap3.toString());




        LOGGER.info(MDC.getCopyOfContextMap().toString());
    }


    @Test
    public void LogTest(){
        String a = "1";
        String b = "2";
        String c = "3";
        Exception e = new Exception("just a exception");
        LOGGER.info("a={},b={},c={}",a,b,c);
        LOGGER.error("a={},b={},c={}",a,b,c,e);
    }

}
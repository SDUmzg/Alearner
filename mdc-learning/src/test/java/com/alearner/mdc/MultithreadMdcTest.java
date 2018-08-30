package com.alearner.mdc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * Created by mzg on 2018/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MultithreadMdcTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultithreadMdcTest.class);

    private MultithreadMdc multithreadMdc = new MultithreadMdc();


    @Test
    public void mdcTest(){
        LOGGER.info("------模拟第一次请求------开始------");
        LOGGER.info("set MDC uuid = alearner , user = Tom");
        MDC.put("uuid","alearner");
        MDC.put("user","Tom");
        Map<String , String> map = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        LOGGER.info(" in  test class map = {}",map);
        Map<String,Future> resFuture = multithreadMdc.UpperCaseStrList(map);
        Map<String,String> res = getMapFromFuture(resFuture);
        LOGGER.info("after test res = {}",res);
        LOGGER.info("------模拟第一次请求------结束------");
        LOGGER.info("------模拟第二次请求------开始------");
        LOGGER.info("set MDC uuid = alearner , user = Tom");
        MDC.put("uuid","alearner");
        MDC.put("user","Tom");
        Map<String , String> map1 = new HashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        LOGGER.info(" in  test class map = {}",map1);
        Map<String,Future> resFuture1 = multithreadMdc.UpperCaseStrList(map1);
        Map<String,String> res1 = getMapFromFuture(resFuture1);
        LOGGER.info("after test res = {}",res1);
        LOGGER.info("------模拟第一次请求------结束------");


    }


    public Map<String,String> getMapFromFuture(Map<String,Future> resFuture){
        Map<String,String> res = new HashMap<>();
        resFuture.forEach((k,v)->{
            try {
                res.put(k,v.get().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        return res;
    }
}
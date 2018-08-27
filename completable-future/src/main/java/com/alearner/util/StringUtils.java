package com.alearner.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by mzg on 2018/8/27.
 */
public  class StringUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtils.class);

    public  void UpcaseWordList(String [] strArr){


        LOGGER.info("upcase word list start ");
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("dataService-execute-thread-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(100, 1500,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
        List<Object> data = new ArrayList<>();
        List<String> strList = Arrays.asList(strArr);

        Map<String,String> mdcMap = MDC.getCopyOfContextMap();
        CompletableFuture []futures = strList.stream()
                .map(str->CompletableFuture.supplyAsync(()->{
                    MDC.setContextMap(mdcMap);
                    LOGGER.info("str = {} ",str);
                    return str.toUpperCase();
                },threadPool).whenComplete((v,e)->{
                    LOGGER.info("add data : {}",v);
                    data.add(v);
                    LOGGER.info("mdc clear start");
                    MDC.clear();
                    LOGGER.info("mdc clear end");
                        })).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        System.out.println(data);
        LOGGER.info("upcase word list end ");
    }

}

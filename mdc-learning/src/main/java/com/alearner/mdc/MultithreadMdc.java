package com.alearner.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mzg on 2018/8/29.
 */
public class MultithreadMdc {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultithreadMdc.class);

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public Map UpperCaseStrList(Map<String, String> map) {
        LOGGER.info("UpperCaseStrList Method start");
        LOGGER.info("map = {}", map);
        Map<String, Future> res = new HashMap<>();
        map.forEach((k, v) -> {
            res.put(k, executorService.submit(new StringCallable(v)));
        });
        LOGGER.info("res = {}", res);
        return res;
    }

    private class StringCallable implements Callable<Object> {

        private final String str;

        private final Map<String, String> mdcMap;

        public StringCallable(String str) {
            this.str = str;
            mdcMap = MDC.getCopyOfContextMap();
        }

        @Override
        public Object call() throws Exception {
            LOGGER.info("call method start");
            LOGGER.info("before setContextMap in this thread , Map of MDC is {}", MDC.getCopyOfContextMap());
            LOGGER.info("***************************");
            MDC.setContextMap(mdcMap);
            LOGGER.info("after setContextMap in this thread , Map of MDC is {}", MDC.getCopyOfContextMap());
            String res = str.toUpperCase();
            LOGGER.info("str = {} , toUpperCase , res = {}", str, res);
            LOGGER.info("after MDC clear in this thread , Map of MDC is {}", MDC.getCopyOfContextMap());
            return res;
        }
    }
}

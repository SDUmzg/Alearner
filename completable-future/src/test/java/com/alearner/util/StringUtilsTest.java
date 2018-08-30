package com.alearner.util;

import com.alearner.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by mzg on 2018/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StringUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtilsTest.class);

    @Test
    public void upcaseWordList() throws Exception {
        System.out.println("---------------------------------------------------");
        String uuid = UUID.randomUUID().toString();
        MDC.put("uuid",uuid);
        MDC.put("pin","mzg");
        LOGGER.info("test start");
        StringUtils stringUtils = new StringUtils();
        String[] strArr = {"sada","asdasd","asdasd","fdsdg","gfgdg"};
        stringUtils.UpcaseWordList(strArr);
        LOGGER.info("test end");
        System.out.println("---------------------------------------------------");
    }


}
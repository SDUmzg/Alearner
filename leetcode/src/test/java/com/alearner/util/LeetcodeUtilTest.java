package com.alearner.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class LeetcodeUtilTest {

    private static final Logger LOGGR = LoggerFactory.getLogger(LeetcodeUtilTest.class);

    @Test
    public void twoSum() {

        int [] a = {-3,4,3,90};
        int target = 0;
        int[] res = LeetcodeUtil.twoSum(a,target);
        LOGGR.info("res[0] = {} , res[1]={}",res[0],res[1]);
    }

    @Test
    public void twoSum1() {

        int [] a = {-3,4,3,90};
        int target = 0;
        int[] res = LeetcodeUtil.twoSum1(a,target);
        LOGGR.info("res[0] = {} , res[1]={}",res[0],res[1]);
    }

    @Test
    public void twoSum2() {

        int [] a = {-3,4,3,90};
        int target = 0;
        int[] res = LeetcodeUtil.twoSum2(a,target);
        LOGGR.info("res[0] = {} , res[1]={}",res[0],res[1]);
    }
}
package com.alearner.timezone.util;

import com.alearner.timezone.bean.DateRange;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

/**
 * @author: mazongguang
 * @version: v1.0
 * @description: com.alearner.timezone.util
 * @date:2019/9/17
 */
public class DateUtilTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(DateUtilTest.class);

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void dateTest() throws JsonProcessingException {
        DateRange dateRange = generatorDateRange();
        LOGGER.info("process Date before , dateRange = {}", serialize(dateRange));
        LOGGER.info("startDate timestamp = {}",dateRange.getStartDate().getTime());
        LOGGER.info("endDate timestamp = {}",dateRange.getEndDate().getTime());
        Date startDateAfter = DateUtil.getStartTimeInDay(dateRange.getStartDate());
        Date endDateAfter = DateUtil.getEndTimeInDay(dateRange.getEndDate());
        dateRange.setStartDate(startDateAfter);
        dateRange.setEndDate(endDateAfter);
        LOGGER.info("process Date after , dateRange = {}", serialize(dateRange));
    }

    @Test
    public void endDateTest(){
        DateRange dateRange = generatorDateRange();
        LOGGER.info("process Date before , dateRange = {}", serialize(dateRange));
        LOGGER.info("endDate timestamp = {}",dateRange.getEndDate().getTime());
        Date endDateAfter = DateUtil.getEndTimeInDay(dateRange.getEndDate());
        LOGGER.info("endDate to Sting = {}",endDateAfter);
        dateRange.setEndDate(endDateAfter);
        LOGGER.info("process Date after , dateRange = {}", serialize(dateRange));
    }

    private DateRange generatorDateRange() {
        try {
            return objectMapper.readValue(DATE_RANGE_JSON, DateRange.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String serialize(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String DATE_RANGE_JSON = "{\"startDate\":\"2019-09-16 00:00:00\",\"endDate\":\"2019-09-17 23:59:59\"}";

}
package com.alearner.schema.datasource;

import com.alearner.Model.mysql.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 */
public class DatasourceProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourceProcessor.class);

    @Autowired
    private ApplicationContext context;

    private ObjectMapper objectMapper = new ObjectMapper();



    public Map<String,Object> process(Map<String,Datasource> datasource,Map<String,Object> param){
        Map<String,Object> results = new HashMap<>();
        datasource.forEach((k,v)->{
            if (v instanceof MysqlDataSource){
            }
        });
        return null;
    }

}

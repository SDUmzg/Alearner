package com.alearner.schema.datasource;

import com.alearner.common.BaseResult;
import com.alearner.common.CommonResponse;
import com.alearner.common.ErrorStatus;
import com.alearner.dao.BaseBodyParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 */
public class DatasourceProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourceProcessor.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MysqlRequestBuilder mysqlRequestBuilder;

    private ObjectMapper objectMapper = new ObjectMapper();



    public Map<String,Object> process(Map<String,Datasource> datasource,Map<String,Object> param){
        Map<String,Object> results = new HashMap<>();
        datasource.forEach((k,v)->{
            if (v instanceof MysqlDataSource){

            }
        });
        return null;
    }


    /**
     * Get BaseResult from Mysql
     * @param mysqlDataSource mysql datasource
     * @param param parameters that required by schema
     * @return BaseResult
     * */
    public BaseResult getMysqlResult(MysqlDataSource mysqlDataSource,Map<String,Object> param){
        String [] names = mysqlDataSource.getName().split("\\.");
        String className = names[0];
        String methodName = names[1];
        Object obj = context.getBean(className);
        if (obj ==  null){
            String msg = MessageFormat.format("Mysql Service not found by name. className = {0}",className);
            throw new RuntimeException(msg);
        }
        Method method;
        try {
            method =  obj.getClass().getMethod(methodName, BaseBodyParam.class);
        } catch (NoSuchMethodException e) {
            String msg = MessageFormat.format("Mysql service method not found by name. className={0}, methodName={1}", className, methodName);
            throw new RuntimeException(msg);
        }


        try {
            BaseBodyParam baseBodyParam = mysqlRequestBuilder.createBaseBody(mysqlDataSource,param);
            CommonResponse<BaseResult> response = (CommonResponse<BaseResult>)method.invoke(obj,baseBodyParam);
            if (!ErrorStatus.SUCCESS.equals(response.getStatus())){
                LOGGER.error("Failed to access Mysql service. className={}, methodName={}, status={}, errMsg={}", className, method, response.getStatus(), response.getErrMsg());
                return null;
            }
            return response.getResult();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }




}

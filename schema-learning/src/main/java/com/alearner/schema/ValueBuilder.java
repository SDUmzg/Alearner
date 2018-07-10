package com.alearner.schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mzg on 2018/7/10.
 */
public class ValueBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValueBuilder.class);

    @Autowired
    private ApplicationContext applicationContext;

    private ObjectMapper objectMapper = new ObjectMapper();

    public Object getValue(ValueDefinition valueDefinition, Map<String,Object>parameters){
        if (!StringUtils.isEmpty(valueDefinition.getValue())){
            final Pattern pattern = Pattern.compile("^\\$\\{(.*)\\}$");
            Matcher matcher = pattern.matcher(valueDefinition.getValue());
            if (matcher.matches()){
                String p = matcher.group(1);
                return parameters.get(p);
            }
            return valueDefinition.getValue();
        }else if (!StringUtils.isEmpty(valueDefinition.getResolver())){
            //TODO add class ValueResolver
            return null;
        }else {
            String definition = parseDefinition(valueDefinition);
            String msg = MessageFormat.format("Unknown value definition. definition={0}", definition != null ? definition : "");
            throw new RuntimeException(msg);
        }
    }

    public String getStringValue(ValueDefinition valueDefinition,Map<String,Object> parameters){
        Object obj = getValue(valueDefinition,parameters);
        if (obj instanceof String){
            return (String)obj;
        }else {
            String definition = parseDefinition(valueDefinition);
            LOGGER.warn("Failed to get string value by definition, as it is not String. definition={}", definition);
            return null;
        }
    }

    public Integer getIntegerValue(ValueDefinition valueDefinition,Map<String,Object> parameters){
        Object obj = getValue(valueDefinition,parameters);
        if (obj instanceof Integer){
            return (Integer)obj;
        }else if (obj instanceof String) {
            try{
                return Integer.valueOf((String) obj);
            }catch (NumberFormatException e){
                LOGGER.warn("Failed to get integer value by definition, as it is not Integer. value={}", obj);
                return null;
            }
        }else {
            String definition = parseDefinition(valueDefinition);
            LOGGER.warn("Failed to get integer value by definition, as it is not Integer. definition={}, value={}", definition, obj);
            return null;
        }
    }



    private String parseDefinition(ValueDefinition valueDefinition){
        try {
            return objectMapper.writeValueAsString(valueDefinition);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

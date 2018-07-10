package com.alearner.schema.datasource;

import com.alearner.schema.ValueDefinition;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by mzg on 2018/7/9.
 */
@ToString
@Setter
@Getter
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY,property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = MysqlDataSource.class,name = "mysql")})
public abstract class Datasource implements Serializable {
    protected List<String> dimension;
    protected List<String> metric;
    protected Map<String,ValueDefinition> filter;
    protected List<Map<String,ValueDefinition>> sort;
    protected ValueDefinition top;
    protected String resultAssert;
}

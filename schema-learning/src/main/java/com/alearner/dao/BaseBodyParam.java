package com.alearner.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 */
@Setter
@Getter
public class BaseBodyParam implements Serializable,Cloneable {

    @JsonProperty
    private List<String> dimension;
    @JsonProperty
    private List<String> metric;
    @JsonProperty
    private Map<String,Object> filter;
    @JsonProperty
    private List<Map<String,String>> sort;
    @JsonProperty
    private Integer limit;
    @JsonProperty
    private Boolean rawData;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }



}

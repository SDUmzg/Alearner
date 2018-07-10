package com.alearner.schema.datasource;

import com.alearner.schema.ValueDefinition;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * Created by mzg on 2018/7/9.
 */
@Setter
@Getter
public class MysqlDataSource extends Datasource {
    private String name;

    @JsonCreator
    public MysqlDataSource(@JsonProperty("name") String name,
                           @JsonProperty("dimension") List<String> dimension,
                           @JsonProperty("metric") List<String> metric,
                           @JsonProperty("filter") Map<String,ValueDefinition> filter,
                           @JsonProperty("sort") List<Map<String,ValueDefinition>> sort,
                           @JsonProperty("top") ValueDefinition top) {
        this.name = name;
        this.dimension = dimension;
        this.metric = metric;
        this.filter = filter;
        this.sort = sort;
        this.top = top;
    }
}

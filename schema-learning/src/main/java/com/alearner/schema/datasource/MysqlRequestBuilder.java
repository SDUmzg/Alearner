package com.alearner.schema.datasource;

import com.alearner.dao.BaseBodyParam;
import com.alearner.schema.ValueBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 * Builder of Mysql request. It will build header and body which are properties of Mysql request.
 * Mysql body request will be constructed based on dimension, metric, filter, sort and limit. Dimension and metric are constant defined in schema.
 * Filter, sort and limit will be resolved by value definition, it could be parameter or candidate resolver.
 * JSF header contains authentication information.
 */
@Component
public class MysqlRequestBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MysqlRequestBuilder.class);

    @Autowired
    private ValueBuilder valueBuilder;

    public BaseBodyParam createBaseBody(Datasource datasource, Map<String, Object> param) {
        BaseBodyParam body = new BaseBodyParam();
        if (datasource.getDimension() != null) {
            body.setDimension(datasource.getDimension());
        }
        if (datasource.getMetric() != null) {
            body.setMetric(datasource.getMetric());
        }
        if (datasource.getFilter() != null) {
            Map<String, Object> filter = new HashMap<>();
            datasource.getFilter().forEach((k, v) -> {
                filter.put(k, valueBuilder.getValue(v, param));
            });
            body.setFilter(filter);
        }
        if (datasource.getSort() != null) {
            List<Map<String, String>> sorts = new ArrayList();
            datasource.getSort().forEach(s -> {
                final Map<String, String> sort = new HashMap<>();
                s.forEach((k, v) -> {
                    String value = valueBuilder.getStringValue(v, param);
                    if (!StringUtils.isEmpty(value)) {
                        sort.put(k, value);
                    } else {
                        LOGGER.warn("Ignore sort as its value is not defined. sort={}", k);
                    }
                });
                sorts.add(sort);
            });
            body.setSort(sorts);
        }
        if (datasource.getTop() != null) {
            Integer top = valueBuilder.getIntegerValue(datasource.getTop(), param);
            if (top != null) {
                body.setLimit(top);
            }
        }

        return body;
    }

}

package com.alearner.schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * Created by mzg on 2018/7/10.
 * process the process the dataflow that DefaultSchema defind.
 */
@Component
public class DefaultSchemaInterpreter implements SchemaInterpreter<DefaultSchema,Map> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSchemaInterpreter.class);


    @Override
    public Map process(DefaultSchema schema, Map<String, Object> parameters) {
        return null;
    }

    @Override
    public Class<DefaultSchema> getType() {
        return null;
    }
}

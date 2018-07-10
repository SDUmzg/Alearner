package com.alearner.schema;

import com.alearner.schema.datasource.DatasourceProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * Created by mzg on 2018/7/10.
 * process the process the dataflow that DefaultSchema defind.
 */
@Component
public class DefaultSchemaInterpreter implements SchemaInterpreter<DefaultSchema,Map> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSchemaInterpreter.class);

    @Autowired
    private DatasourceProcessor datasourceProcessor;


    @Override
    public Map process(DefaultSchema schema, Map<String, Object> parameters) {
        Map<String,Object> dsResults = datasourceProcessor.process(schema.getDatasource(),parameters);
        LOGGER.info(dsResults.toString());
        return dsResults;
    }

    @Override
    public Class<DefaultSchema> getType() {
        return DefaultSchema.class;
    }
}

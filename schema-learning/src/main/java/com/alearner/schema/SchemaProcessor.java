package com.alearner.schema;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 */
public class SchemaProcessor {

    @Autowired
    private SchemaFactory schemaFactory;

    @Autowired
    private List<SchemaInterpreter> interpreters;

    private Map<Class,SchemaInterpreter> interpreterMap = new HashMap<>();

    /**
     * Registry all interpreters and put it in a map so that it could be found by class name.
     * */
    @PostConstruct
    public void init(){
        interpreters.forEach(i->{
            interpreterMap.put(i.getType(),i);
        });
    }

    /**
     * Find a schema by name and process the schema based on specified parameters.
     *
     * @param schemaName schema name
     * @param type       schema class
     * @param parameters parameters that required in schema.
     * @return Process result
     */
    public Object process(String schemaName,Class<? extends BaseSchema> type,Map<String,Object> parameters){
        // Get Schema definition by nameand type
        BaseSchema schema = schemaFactory.getSchemaInstance(schemaName,type);

        if (schema == null){
            throw new RuntimeException("Can not find schema definition");
        }
        //Get corresponding interpreter by type
        SchemaInterpreter interpreter = interpreterMap.get(type);
        //process the schema
        return interpreter.process(schema,parameters);
    }


}

package com.alearner.schema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mzg on 2018/7/9.
 */
@Service
public class SchemaFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchemaFactory.class);

    private ObjectMapper objectMapper = new ObjectMapper();


    /**
     * Read Schema from json file to target class
     * @Param name
     * @Param clz
     * @Param S
     * @Return  Target Schema ,or null if failed
     * */
    public <S extends BaseSchema> S getSchemaInstance(String name,Class<S> clz){

        // load schema configuration by name
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("schema/"+name+".json");
        try {
            S schema = objectMapper.readValue(inputStream,clz);
            schema.schemaValidate();
            return schema;
        }catch (IOException e){
            LOGGER.error("Failed to load schema configuration. schemaName={}",name,e);
            return null;
        }
    }
}

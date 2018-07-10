package com.alearner.schema;

import java.util.Map;

/**
 * Created by mzg on 2018/7/10.
 *
 * Interface to process schema
 * @param <S> schema class
 * @param <R> return class
 */
public interface SchemaInterpreter<S extends BaseSchema,R> {

    /**
     * process the schema and return the value
     * @param schema object
     * @param parameters parameters which are required by schema
     * */
    R process(S schema, Map<String, Object> parameters);

    /**
     * What type of schema this interpreter support.
     *
     * @return
     * */
    Class<S> getType();
}

package com.alearner.schema;

import com.alearner.schema.datasource.Datasource;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by mzg on 2018/7/9.
 */
@Setter
@Getter
public class DefaultSchema extends BaseSchema {

    private Map<String,Datasource> datasource;



    @Override
    public void schemaValidate() {

    }
}

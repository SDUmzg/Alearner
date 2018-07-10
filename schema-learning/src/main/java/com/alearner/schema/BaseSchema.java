package com.alearner.schema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by mzg on 2018/7/9.
 */
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = DefaultSchema.class,name = "default")})
public abstract class BaseSchema implements Serializable {
    private String name;

    @JsonIgnore
    public abstract void schemaValidate();
}

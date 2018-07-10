package com.alearner.schema;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by mzg on 2018/7/9.
 */
@Setter
@Getter
public class ValueDefinition implements Serializable {
    private String value;
    private String resolver;
}

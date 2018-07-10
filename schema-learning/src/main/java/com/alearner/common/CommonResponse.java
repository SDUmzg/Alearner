package com.alearner.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by mzg on 2018/7/10.
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> implements Serializable {
    private Integer status;
    private String errMsg;
    private T result;

    public CommonResponse(){
        this.status = ErrorStatus.SUCCESS;
    }

    public void setStatus(T result){
        this.result = result;
    }

    public void setError(Integer status,String errMsg){
        this.status = status;
        this.errMsg = errMsg;
    }


}

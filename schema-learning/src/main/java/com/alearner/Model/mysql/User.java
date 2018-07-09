package com.alearner.Model.mysql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mzg on 2018/7/9.
 */
@Setter
@Getter
@ToString
public class User {
    private int id;
    private String name;
    private String sex;
    private String phone;
    private String email;
    private int ableStatus;
    private String description;
    private String createTime;
    private String updateTime;
}

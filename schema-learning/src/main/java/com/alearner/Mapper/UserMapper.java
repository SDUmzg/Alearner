package com.alearner.Mapper;

import com.alearner.Model.mysql.User;
import com.alearner.dao.BaseBodyParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;

/**
 * Created by mzg on 2018/7/9.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(@Param("name") String name);

    LinkedHashMap findUser(BaseBodyParam baseBodyParam);
}

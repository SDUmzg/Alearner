package com.alearner.Mapper;

import com.alearner.Application;
import com.alearner.Model.mysql.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by mzg on 2018/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void test1(){
        User user = userMapper.findByName("小明");
        System.out.println(user.toString());
    }
}
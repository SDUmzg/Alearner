package com.alearner.Mapper;

import com.alearner.Application;
import com.alearner.Model.mysql.User;
import com.alearner.dao.BaseBodyParam;
import com.alearner.schema.DefaultSchema;
import com.alearner.schema.SchemaProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.MarshalledObject;
import java.util.*;


/**
 * Created by mzg on 2018/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    SchemaProcessor schemaProcessor;

    @Test
    public void test1(){
        User user = userMapper.findByName("小明");
        System.out.println(user.toString());
    }

    @Test
    public void test2(){
        BaseBodyParam baseBodyParam = new BaseBodyParam();
        List<String> dimension = new ArrayList<>();
        dimension.add("name");
        List<String> metric = new ArrayList<>();
        metric.add("id");
        metric.add("sex");
        metric.add("phone");
        metric.add("email");
        metric.add("able_status");
        Map<String, Object> filter = new HashMap<>();
        filter.put("sex","男");
        filter.put("phone","17865160000");
        List<Map<String,String>> sort = new ArrayList<>();
        Map<String,String > sort_item = new HashMap<>();
        sort_item.put("id","asc");
        sort.add(sort_item);
        Integer limit = 3;
        baseBodyParam.setDimension(dimension);
        baseBodyParam.setMetric(metric);
        baseBodyParam.setFilter(filter);
        baseBodyParam.setSort(sort);
        baseBodyParam.setLimit(limit);

        LinkedHashMap result = userMapper.findUser(baseBodyParam);
        System.out.println(result.toString());
    }


    @Test
    public void test3(){
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("sex","男");
        parameters.put("phone","17865160000");
        parameters.put("limit",3);
        Object result = schemaProcessor.process("UserMapper", DefaultSchema.class,parameters);
        System.out.println(result.toString());


    }
}
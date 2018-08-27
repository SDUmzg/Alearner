package com.alearner.Mapper;


import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtil;
import com.bazaarvoice.jolt.JsonUtilImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by mzg on 2018/7/11.
 */
@SpringBootTest
public class JoltSampleTest {

    @Test
    public  void JoltTest1(){
        // How to access the test artifacts, i.e. JSON files
        //  JsonUtils.classpathToList : assumes you put the test artifacts in your class path
        //  JsonUtils.filepathToList : you can use an absolute path to specify the files

        JsonUtil jsonUtil = new JsonUtilImpl();
        List  chainrSepcJson = jsonUtil.classpathToList("/json/sample/spec.json");
        Chainr chainr = Chainr.fromSpec(chainrSepcJson);

        Object inputJson = jsonUtil.classpathToObject("/json/sample/input.json");

        Object transformedOutput = chainr.transform(inputJson);
        System.out.println(jsonUtil.toJsonString(transformedOutput));
    }

}

package com.hls.jsonandfile;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.hls.jsonandfile
 * @Author: helishi
 * @CreateDate: 2017/12/11
 * @Description:
 */
public class JsonTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonTest.class);
    public static void main(String[] args){
        //jsonObject();
        //createJsonByMap();
        createJsonByBean();
    }

    /**
     * {
     *     "name" : "张三",
     *     "age" : 25.2,
     *     "birthday" : "1990-01-01",
     *     "school" : "蓝翔",
     *     "major: : [ "理发" , "挖掘机"],
     *     "has_girlfriend" : false,
     *     "car" : null,
     *     "house" : null,
     *     "comment" : "这是一个注释"
     * }
     */
    private static void jsonObject(){
        Object nullObj = null;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","张三");
        jsonObject.put("age",25.2);
        jsonObject.put("birthday","1990-01-01");
        jsonObject.put("school","蓝翔");
        jsonObject.put("major",new String[]{"理发","挖掘机"});
        jsonObject.put("has_girlfriend" , false);
        jsonObject.put("car",nullObj); //不能直接传入null
        jsonObject.put("house",nullObj);
        jsonObject.put("comment","这是一个注释");
        LOGGER.info(jsonObject.toString());//toString() 将jsonObject转化为字符串形式
    }

    /**
     * 通过hashmap
     */
    private static void createJsonByMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        Object nullObj = null;
        map.put("name","张三");
        map.put("age",25.2);
        map.put("birthday","1990-01-01");
        map.put("school","蓝翔");
        map.put("major",new String[]{"理发","挖掘机"});
        map.put("has_girlfriend" , false);
        map.put("car",nullObj); //不能直接传入null
        map.put("house",nullObj);
        map.put("comment","这是一个注释");
        JSONObject jsonObject = new JSONObject(map);
        LOGGER.info(jsonObject.toString());
    }

    /**
     * 通过javabean方式构建json -----推荐方式：业务对象和javabean可以重用
     */
    private static void createJsonByBean(){
        DiaoSi diaoSi = new DiaoSi();
        diaoSi.setName("张三");
        diaoSi.setAge(25.2);
        diaoSi.setBirthday("1990-01-01");
        diaoSi.setSchool("蓝翔");
        diaoSi.setMajor(new String[]{"理发","挖掘机"});
        diaoSi.setHas_girlfriend(false);
        diaoSi.setCar(null);
        diaoSi.setHouse(null);
        diaoSi.setComment("这是一个注释！");
        LOGGER.info(new JSONObject(diaoSi).toString());
    }
}

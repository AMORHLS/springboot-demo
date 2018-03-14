package com.hls.gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hls.jsonandfile.DiaoSi;

import java.lang.reflect.Field;

/**
 * @Package: com.hls.gson
 * @Author: helishi
 * @CreateDate: 2017/12/12
 * @Description: 利用javabean，gson创建到转化为json
 */
public class GsonCreate {
    public static void main(String[] args){
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
        //创建gson
        /*Gson gson = new Gson();
        System.out.print(gson.toJson(diaoSi));*/
        //格式化输出json
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        //在解析数据时运用自己的解析策略
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                if (field.getName().equals("name")){
                   return "NAME";
                }
                return field.getName();
            }
        });
        Gson gson = gsonBuilder.create();
        System.out.print(gson.toJson(diaoSi));
    }
}

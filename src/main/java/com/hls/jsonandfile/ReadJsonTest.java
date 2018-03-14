package com.hls.jsonandfile;

import org.aspectj.util.FileUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @Package: com.hls.jsonandfile
 * @Author: helishi
 * @CreateDate: 2017/12/11
 * @Description: 从文件读取json(解析)
 */
public class ReadJsonTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(JsonTest.class);
    public static void main(String[] args) throws IOException {
        String url = ReadJsonTest.class.getResource("/file/test.json").getFile();
        readFile(url);
    }
    //利用commonio控件实现文件读取
    public static void readFile(String url) throws IOException {
        File file = new File(url);
        String content = FileUtil.readAsString(file);
        JSONObject jsonObject = new JSONObject(content);
        if (!jsonObject.isNull("name")){
            LOGGER.info("姓名是："+jsonObject.getString("name"));
        }
        if (!jsonObject.isNull("nickname")){
            LOGGER.info("姓名是："+jsonObject.getString("nickname"));
        }

        LOGGER.info("年龄是："+jsonObject.getDouble("age"));
        LOGGER.info("有没有女朋友："+jsonObject.getBoolean("has_girlfriend"));
        JSONArray majorArray = jsonObject.getJSONArray("major"); //获取json当中的数组
        for (int i = 0; i<majorArray.length(); i++){
            String m = (String)majorArray.get(i);
            LOGGER.info("专业-"+(i+1)+m);
        }

    }

    public static void readFile2(String url) throws IOException {
        File file = new File(url);
        String content = FileUtil.readAsString(file);
        JSONObject jsonObject = new JSONObject(content);
        LOGGER.info("姓名是："+jsonObject.getString("name"));
    }
}

package com.hls.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hls.jsonandfile.DiaoSi;
import org.aspectj.util.FileUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @Package: com.hls.gson
 * @Author: helishi
 * @CreateDate: 2017/12/12
 * @Description: gson 对象的反解析
 */
public class GsonRead {
    public static void main(String[] args)throws Exception{
        String url = GsonRead.class.getResource("/file/test.json").getFile();
        File file = new File(url);
        String content = FileUtil.readAsString(file);
        /*Gson gson = new Gson();
        DiaoSi diaoSi = gson.fromJson(content,DiaoSi.class);*/
        //日期的转化
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        DiaosiWithBirthday diaosiWithBirthday = gson.fromJson(content,DiaosiWithBirthday.class);
        System.out.print(diaosiWithBirthday.getBirthday().toString());
    }

}

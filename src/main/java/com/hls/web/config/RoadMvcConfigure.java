package com.hls.web.config;

import com.hls.web.interceptor.RoadInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package: com.hls.web.config
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: mvc配置
 */
@Configuration
public class RoadMvcConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对所有的URL进行拦截
        registry.addInterceptor(new RoadInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

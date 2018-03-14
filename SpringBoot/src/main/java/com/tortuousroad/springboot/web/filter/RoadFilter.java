package com.tortuousroad.springboot.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * 过滤器
 *
 * @author GuFeng
 * @version 1.0
 * @since 2017/6/11 下午11:31
 */
@WebFilter(filterName = "RoadFilter", urlPatterns = "/*")
public class RoadFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("RoadFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("RoadFilter.doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("RoadFilter.destroy");
    }
}

package com.hls.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Package: com.hls.web.filter
 * @Author: helishi
 * @CreateDate: 2017/12/8
 * @Description: 过滤器  在启动类加@ServletComponentScan
 */
@WebFilter(filterName = "RoadFilter",urlPatterns = "/*")
public class RoadFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("RoadFilter///////////init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
        logger.info("RoadFilter///////////doFilter");
    }

    @Override
    public void destroy() {
        logger.info("RoadFilter///////////destroy");
    }
}

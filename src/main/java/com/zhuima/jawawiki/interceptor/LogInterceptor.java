package com.zhuima.jawawiki.interceptor;


import com.zhuima.jawawiki.filter.LogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 拦截器，Spring框架自带，常用语登录校验，权限校验，请求日志打印等功能
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        logger.info("---------------LogInterceptor 开始 ----------------------");
        logger.info("请求地址: {} {}", request.getRequestURL(), request.getMethod());
        logger.info("远程地址: {}", request.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        request.setAttribute("request-start-time", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("request-start-time");
        logger.info("--------------LogInterceptor 结束耗时: {} ms -------", System.currentTimeMillis() - startTime);

    }
}

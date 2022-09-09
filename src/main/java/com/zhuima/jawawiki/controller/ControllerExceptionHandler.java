package com.zhuima.jawawiki.controller;


import com.zhuima.jawawiki.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    /**
     * 校验异常统一处理
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(BindException exception) {
        CommonResp commonResp = new CommonResp();
        logger.warn("参数校验失败: {}", exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commonResp.setSuccess(false);
        commonResp.setMessage(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commonResp;
    }
}

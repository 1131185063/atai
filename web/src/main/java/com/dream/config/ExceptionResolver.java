package com.dream.config;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@ControllerAdvice
public class ExceptionResolver implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        Result result = (Result) ResultUtils.fail(e.getMessage());
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            Writer writer = response.getWriter();
            writer.write(JSON.toJSONString(result));
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}

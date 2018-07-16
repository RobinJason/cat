package com.cat.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 刘文博
 * 2018/7/9 15:50
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv=new ModelAndView();
        if (ex instanceof MaxUploadSizeExceededException){
            mv.addObject("addInfo","it is bigger");
            mv.setViewName("item/addItem");
            return mv;
        }
        mv.addObject("ex",ex);
        mv.setViewName("error");
        return mv;
    }
}

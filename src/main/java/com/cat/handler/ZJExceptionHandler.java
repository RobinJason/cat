package com.cat.handler;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 刘文博
 * 2018/7/9 15:55
 */
public class ZJExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String maxUploadSize(Model model){
        model.addAttribute("addInfo","it is bigger");
        return "item/addItem";

    }


    @ExceptionHandler(Exception.class)
    public String handlerEx(Exception ex,Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}

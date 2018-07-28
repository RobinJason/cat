package com.cat.common;

/**
 * @Author: LR
 * @Descriprition:定义通用响应码的枚举类
 * @Date: Created in 16:29 2018/7/16
 * @Modified By:
 **/
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

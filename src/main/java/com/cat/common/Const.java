package com.cat.common;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:38 2018/7/16
 * @Modified By:
 **/
public class Const {
    public static final String CURRENT_USER = "currentUser";





    public enum  Gender{
        MALE(1, "male"),
        FEMALE(0, "female");

        Gender(int code, String value){
            this.code = code;
            this.value = value;
        }

        private int code;
        private String value;

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}

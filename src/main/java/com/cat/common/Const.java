package com.cat.common;

import lombok.Getter;
import lombok.Setter;

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

    public enum Healthy{
        HEALTHY(0, "健康"),
        UNHEALTHY(1, "不健康");

        Healthy(int code, String value){
            this.code = code;
            this.value = value;
        }

        @Setter @Getter
        private int code;

        @Setter @Getter
        private String value;
    }
}

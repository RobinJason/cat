package com.cat.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:33 2018/7/18
 * @Modified By:
 **/
public class CatVo {

    @Setter @Getter
    private String name;

    @Getter @Setter
    private String catPic;

    @Getter @Setter
    private String healthyStatus;

}

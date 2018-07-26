package com.cat.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 12:02 2018/7/26
 * @Modified By:
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatListVo {

        private String name;

        private String catPic;

        private int healthyStatus;

        private int gender;

        private Date brith;
}

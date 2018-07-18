package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.vo.CatVo;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:28 2018/7/18
 * @Modified By:
 **/
public interface IMainService {

    ServerResponse<CatVo> getCatVo(Integer id);
}

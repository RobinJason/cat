package com.cat.service;

import com.cat.common.ServerResponse;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageInfo;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:28 2018/7/18
 * @Modified By:
 **/
public interface IMainService {

    ServerResponse<CatVo> getCatVo(Integer id, Integer status);

    ServerResponse<PageInfo> getCatList(Integer gender,Integer status, int pageNum, int pageSize);
}

package com.cat.service;

import com.cat.common.ServerResponse;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 9:25 2018/7/17
 * @Modified By:
 **/
public interface IDiaryService {

    ServerResponse getDetail(Integer userId, String username);
}

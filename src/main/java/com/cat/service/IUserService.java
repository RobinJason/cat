package com.cat.service;

import com.cat.common.ServerResponse;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:03 2018/7/16
 * @Modified By:
 **/
public interface IUserService {

    ServerResponse login(String username, String password);
}

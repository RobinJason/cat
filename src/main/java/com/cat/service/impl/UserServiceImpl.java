package com.cat.service.impl;

import com.cat.common.ServerResponse;
import com.cat.dao.ManMapper;
import com.cat.pojo.Man;
import com.cat.service.IUserService;
import com.cat.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 10:04 2018/7/16
 * @Modified By:
 **/

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private ManMapper manMapper;

    // 登录功能
    public ServerResponse<Man> login(String username, String password){
        // 检查用户名
        int resultCount = manMapper.checkUsername(username);
        if (resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        // 登录 MD5加密
        String md5Password =MD5Util.MD5EncodeUtf8(password); // MD5 加密
        Man man = manMapper.selectLogin(username, md5Password);
        if (man == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        // 将密码设置为空  防止别人抓包
        man.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", man);
    }
}

package com.cat.controller;

import com.cat.common.Const;
import com.cat.common.ServerResponse;
import com.cat.pojo.Man;
import com.cat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: LR
 * @Descriprition: 用户登录功能开发
 * @Date: Created in 9:55 2018/7/16
 * @Modified By:
 **/

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody // 将返回结果序列化为JSON
    public ServerResponse<Man> login(String username, String password, HttpSession session){
        ServerResponse<Man> response = iUserService.login(username, password);
        if (response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

}

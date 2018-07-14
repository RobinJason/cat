package com.cat.interceptor;

import com.cat.entity.Miaoman;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 刘文博
 * 2018/7/9 17:20
 */
public class MyInterceptor implements HandlerInterceptor {
    //前处理,拦截请求到达前端控制器
    // 前处理可以校验一些权限.
    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
        System.err.println("前处理.拦截请求到达前端控制器");
        HttpSession session = Request.getSession();

        Miaoman miaoman = (Miaoman) session.getAttribute("miaoman");
        System.out.println(session);
        if (miaoman!= null){
            return true;
        }else {
            Response.sendRedirect(Request.getContextPath()+"/page/user/login");
            return false;
        }
    }
    //后处理, 渲染视图之前.
    // 可以给modelAndView再设置一些参数. 锦上添花.
    @Override
    public void postHandle(HttpServletRequest Request, HttpServletResponse Response, Object o, ModelAndView modelAndView) throws Exception {
        System.err.println("后处理, 渲染视图之前");
    }
    //后处理, 响应数据之前
    // 请求进来,到响应,执行了多久.
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.err.println("后处理, 响应数据之前");
    }
}

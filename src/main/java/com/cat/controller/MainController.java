package com.cat.controller;

import com.cat.common.ServerResponse;
import com.cat.service.IMainService;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LR
 * @Descriprition: 首页
 * @Date: Created in 11:27 2018/7/18
 * @Modified By:
 **/
@Controller
@RequestMapping("/main/")
public class MainController {

    @Autowired
    private IMainService iMainService;


    @RequestMapping("catNote.do")
    @ResponseBody
    public ServerResponse<CatVo> getCatVo(Integer id, Integer status){
        return iMainService.getCatVo(id, status);
    }

    @RequestMapping("catList.do")
    @ResponseBody
    public ServerResponse<PageInfo> catList(Integer gender, Integer status, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                            @RequestParam(value = "pageNum", defaultValue = "10") int pageSize){

        return iMainService.getCatList(gender,status, pageNum, pageSize);
    }
}

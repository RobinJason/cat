package com.cat.service.impl;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.dao.CatMapper;
import com.cat.pojo.Cat;
import com.cat.service.IMainService;
import com.cat.vo.CatListVo;
import com.cat.vo.CatVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 11:29 2018/7/18
 * @Modified By:
 **/

@Service("iManService")
public class MainServiceImpl implements IMainService {

    @Autowired
    private CatMapper catMapper;

    // 获取帖子信息
    public ServerResponse<CatVo> getCatVo(Integer id, Integer status){
        if (id == null) {
            ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cat cat = catMapper.selectByIdAndStatus(id, status);
        if (cat == null) {
            ServerResponse.createByErrorMessage("此猫不存在");
        }

        // 组装catVo
        CatVo catVo = assembleCatVo(cat);
        return ServerResponse.createBySuccess(catVo);
    }

    private CatVo assembleCatVo(Cat cat){
        CatVo catVo = new CatVo();
        catVo.setName(cat.getName());
        catVo.setCatPic(cat.getPic());
        catVo.setGender(cat.getGender());
        catVo.setBrith(cat.getBirth());
        if(cat.getHealthy() == Const.Healthy.HEALTHY.getCode()){
            catVo.setHealthyStatus(Const.Healthy.HEALTHY.getCode());
    }
        if(cat.getHealthy() == Const.Healthy.UNHEALTHY.getCode()){
            catVo.setHealthyStatus(Const.Healthy.UNHEALTHY.getCode());
        }

        return catVo;
    }

    private CatListVo assembleCatListVo(Cat cat){
        CatListVo catVoList = new CatListVo();
        catVoList.setName(cat.getName());
        catVoList.setCatPic(cat.getPic());
        catVoList.setGender(cat.getGender());
        catVoList.setBrith(cat.getBirth());
        if(cat.getHealthy() == Const.Healthy.HEALTHY.getCode()){
            catVoList.setHealthyStatus(Const.Healthy.HEALTHY.getCode());
        }
        if(cat.getHealthy() == Const.Healthy.UNHEALTHY.getCode()){
            catVoList.setHealthyStatus(Const.Healthy.UNHEALTHY.getCode());
        }

        return catVoList;
    }

    public ServerResponse<PageInfo> getCatList(Integer gender,Integer status, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Cat> catList = catMapper.getCatList(gender, status);

        List<CatListVo> catListVoList = Lists.newArrayList();

        for (Cat catItem : catList) {
            CatListVo catListVo = assembleCatListVo(catItem);
            catListVoList.add(catListVo);
        }

        PageInfo pageInfo = new PageInfo(catList);
        pageInfo.setList(catListVoList);

        return ServerResponse.createBySuccess(pageInfo);
    }

}

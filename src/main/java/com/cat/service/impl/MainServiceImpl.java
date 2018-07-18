package com.cat.service.impl;

import com.cat.common.Const;
import com.cat.common.ResponseCode;
import com.cat.common.ServerResponse;
import com.cat.dao.CatMapper;
import com.cat.pojo.Cat;
import com.cat.service.IMainService;
import com.cat.vo.CatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse<CatVo> getCatVo(Integer id){
        if (id == null) {
            ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cat cat = catMapper.selectByPrimaryKey(id);
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
        if(cat.getHealthy() == Const.Healthy.HEALTHY.getCode()){
            catVo.setHealthyStatus(Const.Healthy.HEALTHY.getValue());
        }
        if(cat.getHealthy() == Const.Healthy.UNHEALTHY.getCode()){
            catVo.setHealthyStatus(Const.Healthy.UNHEALTHY.getValue());
        }

        return catVo;
    }


}

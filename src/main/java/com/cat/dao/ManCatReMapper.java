package com.cat.dao;

import com.cat.pojo.ManCatRe;

public interface ManCatReMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManCatRe record);

    int insertSelective(ManCatRe record);

    ManCatRe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManCatRe record);

    int updateByPrimaryKey(ManCatRe record);
}
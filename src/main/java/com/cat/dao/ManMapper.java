package com.cat.dao;

import com.cat.pojo.Man;

public interface ManMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Man record);

    int insertSelective(Man record);

    Man selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Man record);

    int updateByPrimaryKey(Man record);
}
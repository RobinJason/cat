package com.cat.dao;

import com.cat.pojo.note;

public interface noteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(note record);

    int insertSelective(note record);

    note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(note record);

    int updateByPrimaryKeyWithBLOBs(note record);

    int updateByPrimaryKey(note record);
}
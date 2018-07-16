package com.cat.dao;

import com.cat.pojo.DiaryPic;

public interface DiaryPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DiaryPic record);

    int insertSelective(DiaryPic record);

    DiaryPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DiaryPic record);

    int updateByPrimaryKey(DiaryPic record);
}
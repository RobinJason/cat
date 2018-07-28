package com.cat.dao;

import com.cat.pojo.Cat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cat record);

    int insertSelective(Cat record);

    Cat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);

    Cat selectByIdAndStatus(@Param("id")Integer id, @Param("status") Integer status);

    List<Cat> getCatList(@Param("gender")Integer gender, @Param("status")Integer status);
}
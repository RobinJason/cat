package com.cat.service.impl;

import com.cat.common.ServerResponse;
import com.cat.dao.NoteMapper;
import com.cat.pojo.Note;
import com.cat.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LR
 * @Descriprition: 日记相关功能开发
 * @Date: Created in 9:26 2018/7/17
 * @Modified By:
 **/
@Service("iDiaryService")
public class DiaryServiceImpl implements IDiaryService {

    @Autowired
    private NoteMapper noteMapper;


    // 查看日记详情
    public ServerResponse<Note> getDetail(Integer userId, String username){

        // 从数据库中获取日记信息
        Note note = noteMapper.selectByIdAndUserName(userId, username);
        if (note != null) {
            return ServerResponse.createBySuccess(note);
        }
        return ServerResponse.createByErrorMessage("日记不存在");
    }


}

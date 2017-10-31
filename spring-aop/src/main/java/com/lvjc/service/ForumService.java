package com.lvjc.service;

import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by lvjc on 2017/5/27.
 */
public class ForumService {

    public void removeForum(int forumId) {
        System.out.println("删除forum记录：" + forumId);
        throw new RuntimeException("运行异常");
    }

    public void updateForum() throws Exception{
        System.out.println("更新forum记录");
        throw new SQLException("数据更新异常");
    }
}

package com.lvjc.service.impl;

import com.lvjc.service.ForumService;

/**
 * Created by lvjc on 2017/5/26.
 */
public class ForumServiceImpl implements ForumService {

    @Override
    public void removeTopic(int topicId) {
        System.out.println("删除Topic记录：" + topicId);
    }

    @Override
    public void removeForum(int forumId) {
        System.out.println("删除Forum记录：" + forumId);
    }

    @Override
    public void internalInvokeRemoveTopic(int topicId){
        System.out.println("内部调用removeTopic方法");
        //内部调用的方法不会触发代理
        this.removeTopic(topicId);
    }
}

package com.lvjc.service;

/**
 * Created by lvjc on 2017/5/26.
 */
public interface ForumService {

    void removeTopic(int topicId);

    void removeForum(int forumId);

    void internalInvokeRemoveTopic(int topicId);
}

package com.lvjc.web;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * Created by lvjc on 2017/7/14.
 */
@WebListener
public class SessionAttributeListener
        implements HttpSessionAttributeListener {



    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        Object object = httpSessionBindingEvent.getValue();
        System.out.println("Session Attribute Replaced: " + object);
    }
}

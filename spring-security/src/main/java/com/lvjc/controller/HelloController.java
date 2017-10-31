package com.lvjc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lvjc on 2017/10/9.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    @ResponseBody
    public String home(String username, String password){
        return "home: " + username + "/" + password;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}

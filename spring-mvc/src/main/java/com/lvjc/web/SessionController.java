package com.lvjc.web;

import com.lvjc.domain.Dog;
import com.lvjc.domain.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lvjc on 2017/8/4.
 */
@RestController
@RequestMapping("/session/attribute")
public class SessionController {

    private static final String BIOLOGY = "biology";

    @RequestMapping("/add")
    public void addAttribute(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute(BIOLOGY));
        Person person = new Person("a person");
        session.setAttribute(BIOLOGY, person);
        System.out.println(session.getAttribute(BIOLOGY));
    }
}

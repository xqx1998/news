package com.xqx.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xqx.model.User;
import com.xqx.service.UserService;
import com.xqx.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport {
    UserService userService = new UserServiceImpl();
    public String login(){
        // User user = null;
        // userService.login(user);
        return "toLogin";
    }
}

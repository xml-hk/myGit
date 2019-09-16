package com.funtl.my.shop.web.admin.web.controller;


import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.service.impl.UserServiceImpl;
import my.shop.commons.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MyController {

    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * 默认登录页面
     * @return
     */
    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login(){
       return "index";
    }

    /**
     * 跳转到a.jsp页面
     * @return
     */
    @RequestMapping(value = "main")
    public String main(){
        return "a";
    }

    /**
     * 登录验证
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method =RequestMethod.POST )
    public String homePage(User user, HttpServletRequest request, Model model){
       User user1 = userServiceImpl.getUserEmail(user);
        if (user1 == null){
            model.addAttribute("message","邮箱或密码错误，请重新输入");
           return login();
        }else{
            request.getSession().setAttribute(ConstantUtils.SESSION_USER,user1);
            return "redirect:/main";
        }
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/login";
    }
}

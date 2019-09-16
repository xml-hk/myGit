package com.funtl.my.shop.web.admin.web.controller;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.service.impl.UserServiceImpl;
import my.shop.commons.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 在模型中添加user，如果请求没有id则为空，有就从数据库获取实体
     * @param id
     * @return
     */
    @ModelAttribute
    public User getUser(Integer id){
        User user = new User();
        if(id != null){
            user = userServiceImpl.selectUserId(id);
        }
        return user;
    }
    /**
     * 用户列表
     * @param model
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String userList(Model model){
       List<User> list = userServiceImpl.selectAll();
       model.addAttribute("list",list);
        return "user_list";
    }

    /**
     * 用户表单
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 保存用户信息
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(User user, RedirectAttributes redirectAttributes,Model model){
        System.out.println("controller:userid:"+user.getUserid());
        BaseResult baseResult = userServiceImpl.save(user);
        //状态码为200，保存成功
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }
        else {
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }

    }

    /**
     * 模糊查询
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model){
        List<User> list = userServiceImpl.search(keyword);
        model.addAttribute("list",list);
        return "user_list";
    }
}

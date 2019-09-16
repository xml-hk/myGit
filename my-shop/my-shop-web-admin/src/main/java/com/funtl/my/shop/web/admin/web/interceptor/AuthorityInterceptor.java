package com.funtl.my.shop.web.admin.web.interceptor;


import com.funtl.my.shop.domain.User;
import my.shop.commons.ConstantUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //如果在首页输入请求，请求的视图后缀包含index
        if(modelAndView.getViewName().endsWith("index")){
            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            //如果user不为空
            if(user != null){
                //重定向到首页
                httpServletResponse.sendRedirect("/main");
                return;
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

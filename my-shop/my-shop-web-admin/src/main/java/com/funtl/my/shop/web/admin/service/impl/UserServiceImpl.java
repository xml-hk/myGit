package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.dao.UserDao;
import com.funtl.my.shop.web.admin.service.UserService;
import my.shop.commons.dto.BaseResult;
import my.shop.commons.utils.RegexpUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public void deleteUser(User user) {

    }

    @Override
    public List<User> search(String keyword) {
        User user = new User();
        user.setUsername(keyword);
        user.setEmail(keyword);
        return userDao.search(user);
    }

    /**
    *@Description 登录验证
    *@Author Mr.Ren
    *@Date 2019/8/31 0031
    *@Time 17:05
    */
    @Autowired
    private UserDao userDao;
    @Override
    public User getUserEmail(User user) {
        User user1 = userDao.selectUserEmail(user);
        if(user1.getEmail().equals(user.getEmail())){
            String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if (user1.getPassword().equals(md5Password)){
                return user1;
            }
        }
        return null;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    /**
     * 保存用户信息
     * @param user
     */
    @Override
    public BaseResult save(User user) {
        //后台验证默认结果
        BaseResult baseResult = checkUser(user);
        //将密码进行加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        //响应码为200时，进行保存操作
        if(baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //新增用户信息
            if(user.getUserid() == 0){
                userDao.addUser(user);
            }
            //修改用户信息
            else{
                userDao.updateUser(user);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public User selectUserId(int id) {
        User user = new User();
        user.setUserid(id);
        return userDao.selectUserEmail(user);
    }

    /**
     * 用户信息的有效性验证
     * @param user
     */
    private BaseResult checkUser(User user){
        BaseResult baseResult = BaseResult.success();
        User user1 = null;
        if(!("").equals(user.getEmail()) || user.getEmail() != null){
            user1 = userDao.selectUserEmail(user);
        }
        if(StringUtils.isBlank(user.getEmail())){
            baseResult = BaseResult.fail("邮箱不能为空，请重新输入");
        }
        else if (!RegexpUtils.checkEmail(user.getEmail())){
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        }
        else if(StringUtils.isBlank(user.getUsername())){
            baseResult = BaseResult.fail("姓名不能为空，请重新输入");
        }
        else if(StringUtils.isBlank(user.getPassword())){
            baseResult = BaseResult.fail("密码不能为空，请重新输入");
        }
        else if(user1 != null && user.getUserid() == 0){
            baseResult = BaseResult.fail("输入的邮箱已经存在，请重新输入");
        }
        return baseResult;
    }
}

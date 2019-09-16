package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.dao.TbUserDao;
import com.funtl.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<User> selectAll() {
        return tbUserDao.selectAll();
    }
}

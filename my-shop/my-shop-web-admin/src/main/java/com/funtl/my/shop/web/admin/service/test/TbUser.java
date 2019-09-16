package com.funtl.my.shop.web.admin.service.test;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.dao.TbUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUser {
//    @Autowired
//    private TbUserDao tbUserDao;
//
//    @Test
//    public void testSelectAll(){
//        List<User> tbUsers = tbUserDao.selectAll();
//        for (User user:
//             tbUsers) {
//            System.out.println(user.getEmail());
//        }
//    }

    @Test
    public void testMD(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}

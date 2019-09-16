package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserDao {
    List<User> selectAll();
}

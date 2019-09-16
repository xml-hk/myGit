package com.funtl.my.shop.web.admin.service;

import com.funtl.my.shop.domain.User;
import my.shop.commons.dto.BaseResult;

import java.util.List;

public interface UserService {
    User getUserEmail(User user);

    List<User> selectAll();

    BaseResult save(User user);

    User selectUserId(int id);

    List<User> search(String keyword);

    void deleteUser(User user);
}

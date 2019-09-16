package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@Description 数据访问层
*@Author Mr.Ren
*@Date 2019/8/10 0010
*@Time 17:09
*/
@Repository
public interface UserDao {
    /**
     * 登录验证
     * @param user
     * @return
     */
    User selectUserEmail(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 模糊查询
     * @return
     */
    List<User> search(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int deleteUser(User user);
}

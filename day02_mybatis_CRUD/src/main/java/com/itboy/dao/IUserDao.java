package com.itboy.dao;

import com.itboy.domin.QueryVo;
import com.itboy.domin.User;

import java.util.HashMap;
import java.util.List;

public interface IUserDao  {
    /**
     *
     * @return 查询所有
     */
    List<User> findAll();

    /**
     * 添加信息
     * @param user
     */
     void saveUsers(User user);

    /**
     * 更新信息
     * @param user
     */
     void updateUser(User user);

    /**
     * 删除信息
     * @param userId
     */
     void deleteUser(Integer userId);

    /**
     * 查询一条信息
     * @param userId
     * @return
     */
     User findOne(Integer userId);

    /**
     * 分页查询
     * @param map
     * @return
     */
     List<User> pages(HashMap<String,Integer>map);
    /**
     * 模糊查询
     * @param username
     * @return
     */
     List<User> findName(String username);

    /**
     * 根据QueryVo添加查询用户
     * @param vo
     * @return
     */
     List<User>findUserVo(QueryVo vo);
}

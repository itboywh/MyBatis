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
     * 查询一条信息
     * @param userId
     * @return
     */
     User findOne(Integer userId);

}

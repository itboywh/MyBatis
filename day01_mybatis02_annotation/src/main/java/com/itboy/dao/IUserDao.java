package com.itboy.dao;

import com.itboy.domin.User;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * IUserDao接口就是我们的持久层接口（也可以写成UserDao或者UserMapper
 */
public interface IUserDao {
    /**
     * 查找所有
     */
   @Select("select * from user")
   List <User>findAll();
}

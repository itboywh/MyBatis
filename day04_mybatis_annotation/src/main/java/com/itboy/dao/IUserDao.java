package com.itboy.dao;

import com.itboy.domin.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有
     */
    @Select("select * from user")
    List<User> findAll();
    /**
     * 插入一条用户信息
     */
    @Insert("insert into user (username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);
    /**
     * 根据id删除用户
     */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);
    /**
     * 根据id更新用户信息
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);
    /**
     * 根据id查询用户信息
     */
    @Select("select * from user where id=#{id}")
    User seletbyid(Integer userId);
    /**
     * 根据username 模糊查询用户信息
     */
    @Select("select * from user where  username like #{username}")
    List<User> selectByName(String username);
    /**
     * 查询总条数
     */
    @Select("select count(*) from user")
    int findTotalUser();
}

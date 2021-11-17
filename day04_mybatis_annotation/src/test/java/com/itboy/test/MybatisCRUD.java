package com.itboy.test;

import com.itboy.dao.IUserDao;
import com.itboy.domin.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisCRUD {
    private InputStream in;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private  IUserDao userDao;

    @Before
    public void init()  throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void distory() throws Exception{
        sqlSession.commit();
        in.close();
        sqlSession.close();

    }

    /**
     * 查询所有
     */
    @Test
    public void findAll(){
        List<User> users=userDao.findAll();
        for(User user :users) {
            System.out.println(user);
        }
    }
    @Test
    public void saveUser(){
        User user=new User();
        user.setUsername("小红");
        user.setAddress("河南周口");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    @Test
    public void deleteUser(){
        userDao.deleteUser(59);
    }
    @Test
    public void updateUser(){
        User user=new User();
        user.setId(46);
        user.setUsername("小华华");
        user.setAddress("河南周口");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }
    @Test
    public void selectbyId(){
       User user=userDao.seletbyid(46);
        System.out.println(user);

    }
    @Test
    public void selectByName() {
        List<User> users = userDao.selectByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void findTotalUser(){
        int total=userDao.findTotalUser();
        System.out.println("总条数"+total);
    }
}

package com.itboy.test;
import com.itboy.dao.IUserDao;
import com.itboy.domin.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MysqlTest {
    public static void main(String[] args) throws Exception {
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession();
       IUserDao userDao =sqlSession.getMapper(IUserDao.class);
        List<User> users=userDao.findAll();
        for(User user :users) {
            System.out.println(user);
        }
         sqlSession.close();
         in.close();

    }

}

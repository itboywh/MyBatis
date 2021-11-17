package com.itboy.test;

import com.itboy.dao.IUserDao;
import com.itboy.domin.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.InputStream;
import java.util.List;

/**
 * @author wh
 * @date 2021年10月23日14:55
 */
public class test {
    public static void main(String[] args) throws Exception{
        //1.读取xml文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(inputStream);
        //3.使用SqlSession对象
        SqlSession sqlSession = build.openSession();
        //4.使用SqlSession创建dao接口的代理
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        List<User>users=userDao.findAll();
        //5.使用代理对象执行方法
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        inputStream.close();
        sqlSession.close();

    }
}

package com.itboy.test;

import com.itboy.dao.IUserDao;
import com.itboy.dao.impl.userDaoImpl;
import com.itboy.domin.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.junit.Test;

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
        SqlSessionFactory factory = builder.build(inputStream);

        IUserDao userDao = new userDaoImpl(factory);
        List<User>users=userDao.findAll();
        //5.使用代理对象执行方法
        for(User user : users){
            System.out.println(user);
        }
        //6.释放资源
        inputStream.close();

    }
}

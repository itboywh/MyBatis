package com.itboy.dao.impl;

import com.itboy.dao.IUserDao;
import com.itboy.domin.User;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author wh
 * @date 2021年10月25日15:13
 */
public class userDaoImpl implements IUserDao {
    //使用SqlSessionFactory
   private SqlSessionFactory factory;
   public  userDaoImpl(SqlSessionFactory factory){
       this.factory=factory;
   }
    public List<User> findAll() {
      SqlSession sqlSession = factory.openSession();
      List<User> session = sqlSession.selectList("com.itboy.dao.IUserDao.findAll");
        sqlSession.close();
        return session;

    }
}

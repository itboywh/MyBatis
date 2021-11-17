import com.itboy.dao.IAccountDao;
import com.itboy.dao.IUserDao;
import com.itboy.domin.Account;
import com.itboy.domin.AccountUser;
import com.itboy.domin.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author wh
 * @date 2021年11月09日10:16
 */
public class AccountTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void distory() throws Exception {
        //提交事务
        sqlSession.commit();
        inputStream.close();
        sqlSession.close();
    }
    @Test
    public void findAllTest() throws Exception {

        List<Account> lists =accountDao.findAll();
        for (Account list : lists) {
            System.out.println("-------每个account信息-----");
            System.out.println(list);
            System.out.println(list.getUser());
        }
    }
    @Test
    public void findAllAccountTest() throws Exception {

        List<AccountUser> lists =accountDao.findAllAccount();
        for (Account list : lists) {
            System.out.println(list);
        }
    }
}

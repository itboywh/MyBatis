import com.itboy.dao.IUserDao;
import com.itboy.dao.RoleDao;
import com.itboy.domin.Role;
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

public class RoleTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
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

        List<Role> lists =roleDao.findAll();
        for (Role list : lists) {
            System.out.println("-------打印每个角色的信息-------");
            System.out.println(list);
            System.out.println(list.getUsers());

        }
    }
}

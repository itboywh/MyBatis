import com.itboy.dao.IUserDao;
import com.itboy.domin.QueryVo;
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
import java.util.HashMap;
import java.util.List;


/**
 * @author wh
 * @date 2021年11月01日16:13
 */

public class MybatisTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void distory() throws Exception {
        //提交事务
        sqlSession.commit();
        inputStream.close();
        sqlSession.close();
    }

    /**
     * 获取全部测试
     *
     * @throws
     */
    @Test
    public void findAllTest() throws Exception {

        List<User> lists = userDao.findAll();
        for (User list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 添加
     *
     * @throws Exception
     */
    @Test
    public void saveUser() throws Exception {
        User user = new User();
        user.setUsername("last_insert_id");
        user.setBirthday(new Date());
        user.setAddress("河南");
        user.setSex("男");
        System.out.println("保存前" + user);
        userDao.saveUsers(user);
        System.out.println("保存后" + user);
    }

    //更新
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(48);
        user.setUsername("小亮");
        user.setBirthday(new Date());
        user.setAddress("河南");
        user.setSex("女");
        userDao.updateUser(user);
    }

    //删除
    @Test
    public void deleteUser() {
        userDao.deleteUser(42);
    }

    //根据条件查询一条信息
    @Test
    public void findone() {
        User user = userDao.findOne(53);
        System.out.println(user);
    }
    //分页查询
    @Test
    public void pages() throws Exception {
        HashMap<String,Integer>map=new HashMap<String, Integer>();
        map.put("Startindex",0);
        map.put("pageSize",2);
        List<User> lists = userDao.pages(map);
        for (User list : lists) {
            System.out.println(list);
        }
    }

    //根据名字模糊查询
    @Test
    public void findName() throws Exception {

        List<User> lists = userDao.findName("%王%");
        for (User list : lists) {
            System.out.println(list);
        }
    }
    //根据名字模糊查询
    @Test
    public void findUserVo() throws Exception {
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> lists = userDao.findUserVo(vo);
        for (User list : lists) {
            System.out.println(list);
        }

    }

}

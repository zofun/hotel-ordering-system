import com.web.core.mapper.ShiroMapper;
import com.web.core.mapper.UserMapper;
import com.web.core.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class daoTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShiroMapper shiroMapper;

    @Test
    public void testDao(){
        List<User> users = userMapper.queryAll(0, 5);
        for (User u:users){
            System.out.println("--->"+u.toString());
        }
    }


    public void testShiroDao(){
        User user = shiroMapper.getUserByUserName("123456");
        System.out.println(user.toString());
    }
}

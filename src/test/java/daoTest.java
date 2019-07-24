import com.web.core.mapper.HotelMapper;
import com.web.core.mapper.RoomTypeMapper;
import com.web.core.mapper.ShiroMapper;
import com.web.core.mapper.UserMapper;
import com.web.core.pojo.*;
import com.web.utils.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class daoTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShiroMapper shiroMapper;

    @Autowired
    private HotelMapper hotelMapper;


    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Test
    public void testShiroDao(){

        User user = shiroMapper.getUserByUserName("123456");
        System.out.println(user.toString());

        Role role = shiroMapper.getUserRoleByUserId(user.getId());
        System.out.println(role.toString());

        List<Permission> permissions = shiroMapper.getPermissionsByRoleId(role.getId());
        for (Permission p: permissions){
            System.out.println(p.toString());
        }
    }

    @Test
    public void testUserDao(){

        User user = userMapper.selectUserByUsername("123456");
        System.out.println(user.toString());

        User user1=new User();
        user1.setName("瓜皮队友");
        user1.setUsername("2233");
        String password="123456";
        String[] result = EncryptUtils.encryptPassword(password);
        //秘文
        user1.setPassword(result[0]);
        //盐值
        user1.setSalt(result[1]);
        System.out.println(user1.toString());
        userMapper.insertUser(user1);


        String salt = userMapper.selectSaltByUsername("2233");
        System.out.println("查询到的盐值"+salt);

        String pwd = EncryptUtils.getInputPasswordCiph(password,salt);
        System.out.println("重新计算得到的密文"+pwd);
        System.out.println(pwd.equals(result[0]));



    }

    @Test
    public void testHotelDao(){

        List<Hotel> hotels = hotelMapper.queryAll();
        for (Hotel h:hotels){
            System.out.println(h.toString());
        }

    }

    @Test
    public void roomTypeDao(){
        List<RoomTypeInfo> infos = roomTypeMapper.queryRoomTypeList(1,10);
        for (RoomTypeInfo info:infos){
            System.out.println(info);
        }

        RoomType roomType=new RoomType();
        roomType.setCapacity(1);
        roomType.setDesc("这是一个介绍哈哈哈");
        roomType.setDescUrl("/image/jjjj");
        roomType.setPrice("120");
        roomType.setHotelId(1);
        roomType.setRoomType("沙雕专用房子");
        roomTypeMapper.insertRoomType(roomType);
    }


}

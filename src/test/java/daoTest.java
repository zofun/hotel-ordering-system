import com.web.core.mapper.*;
import com.web.core.pojo.*;
import com.web.core.service.ShiroService;
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


    @Autowired
    private RoomMapper roomMapper;


    @Autowired
    private ServiceMapper serviceMapper;


    @Autowired
    private ForegroundMapper foregroundMapper;



    @Test
    public void testShiroDao(){

        User user = shiroMapper.getUserByUserName("111");
        System.out.println(user.toString());


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


        List<RoomType> list = roomTypeMapper.queryByHotelId(1);

        for (RoomType l:list){
            System.out.println(l);
        }
    }


    @Test
    public void roomDao(){

        List<RoomInfo> infos = roomMapper.queryRoomList(0, 10, 1);

        for (RoomInfo r:infos){
            System.out.println(r.toString());
        }

        int count = roomMapper.queryRoomNumOfSubBranch(1);
        System.out.println(count);

        Room room=new Room();
        room.setRoomNo("A*66");
        room.setRoomTypeId(2);

        roomMapper.insertRoom(room);

        int i = roomMapper.queryByRoomNo("A*66", 2);
        System.out.println(i);
    }


    @Test
    public void ServiceDao(){
        List<ServiceInfo> infos = serviceMapper.queryServiceInfoOfSubbranch(0,1,1);
        for (ServiceInfo info:infos){
            System.out.println(info.toString());
        }
    }

    @Test
    public void changeRole(){
        userMapper.updateRole(5,2);
    }

    @Test
    public void foregroundDao(){
        List<UserCheckInInfo> infos = foregroundMapper.searchByName(1, 0, 10, "测");
        for (UserCheckInInfo info:infos){
            System.out.println(info.toString());
        }

        int count=foregroundMapper.searchCount(1,"测");
        System.out.println(count);
    }

    @Test
    public  void  tipDao(){
        List<TipInfo> infos = roomTypeMapper.queryByRecommendStatus();

        for (TipInfo info:infos){
            System.out.println(info);
        }

        infos=roomTypeMapper.queryAllHote(0,5);
        for (TipInfo info:infos){
            System.out.println(info);
        }

    }


}

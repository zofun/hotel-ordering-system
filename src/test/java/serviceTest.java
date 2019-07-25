import com.web.core.pojo.User;
import com.web.core.service.HotelService;
import com.web.core.service.RoleService;
import com.web.core.service.RoomTypeService;
import com.web.core.service.UserService;
import com.web.utils.EncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class serviceTest {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;

    @Test
    public void hotelServiceTest(){
        String hotelList = hotelService.getHotelList();
        System.out.println(hotelList);
    }

    @Test
    public void roomTypeServiceTest() throws IOException {
        String json=roomTypeService.getRoomTypeList(1,10);
        System.out.println(json);
    }

    

    @Test
    public void setUserServiceTest(){
        User user = new User();
        user.setPassword("1");
        user.setUsername("李白");
        String password="123456";
        String[] result = EncryptUtils.encryptPassword(password);
        //秘文
        //user.setPassword(result[0]);

        //userService.register(user);

        //userService.login(user);
    }


    @Test
    public void roleServiceTest(){
        String json = roleService.getRoleList(1,10);
        System.out.println(json);
    }
}

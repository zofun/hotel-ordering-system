import com.web.core.service.HotelService;
import com.web.core.service.RoomTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class serviceTest {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomTypeService roomTypeService;

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
}

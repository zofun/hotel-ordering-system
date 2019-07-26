import com.web.utils.TimeUtils;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testTimeUtil(){
        String time = TimeUtils.getNowTime("yyyy-MM-dd");
        System.out.println(time);
    }
}

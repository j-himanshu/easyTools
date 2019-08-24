package simplify;

import com.hs.easyTools.datatype.EnumUtilTest;
import com.hs.easyTools.simplify.SetEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class SetEnumTest {

    @Test
    public void testSetEnum() {
        Pojo pojo = new Pojo();
//        pojo.setWeekday("SUNDAY");

//        assertEquals(EnumUtilTest.Weekdays.SUNDAY, pojo.getWeekday());
    }
}

@SetEnum
class Pojo {
    private EnumUtilTest.Weekdays weekday;

    public EnumUtilTest.Weekdays getWeekday() {
        return weekday;
    }
}

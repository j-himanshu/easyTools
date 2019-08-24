package com.hs.easyTools.datatype;

import com.hs.easyTools.datatype.EnumUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.*;

@RunWith(JUnit4.class)
public class EnumUtilTest {

    public EnumUtilTest() {
    }

    public enum Weekdays {
        MONDAY(true),
        TUESDAY(true),
        WEDNESDAY(true),
        THURSDAY(true),
        FRIDAY(true),
        SATURDAY(false),
        SUNDAY(false);

        private final boolean isWeekday;

        Weekdays(boolean isWeekday) {
            this.isWeekday = isWeekday;
        }

        boolean isWeekday() {
            return isWeekday;
        }

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    @Test
    public void initialize() {
        EnumUtil.initialize(Weekdays.class);
        assertTrue(EnumUtil.enumStore.containsKey(Weekdays.class));
    }

    @Test
    public void getValueStatic() {
        assertEquals(Weekdays.MONDAY, EnumUtil.getValue(Weekdays.class, "monday"));
        assertEquals(Weekdays.TUESDAY, EnumUtil.getValue(Weekdays.class, "TUESDAY"));
        assertNull(EnumUtil.getValue(Weekdays.class, "wEdNeSdAy"));
        assertTrue(((Weekdays) EnumUtil.getValue(Weekdays.class, "thursday")).isWeekday());
        assertFalse(((Weekdays) EnumUtil.getValue(Weekdays.class, "sunday")).isWeekday());
    }

    @Test
    public void getValue() {
        EnumUtil<Weekdays> e = new EnumUtil<>(Weekdays.class);

        assertEquals(Weekdays.MONDAY, e.getValue("monday"));
        assertEquals(Weekdays.TUESDAY, e.getValue("TUESDAY"));
        assertNull(e.getValue("wEdNeSdAy"));
        assertTrue((e.getValue("thursday")).isWeekday());
        assertFalse((e.getValue("sunday")).isWeekday());
    }

    @Test(expected = RuntimeException.class)
    public void unSupported() {
        EnumUtil.initialize(String.class);
    }
}
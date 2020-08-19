package algorithm;

import java.util.Calendar;

public class TimeFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));

    }

}

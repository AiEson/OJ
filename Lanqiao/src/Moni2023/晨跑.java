package Moni2023;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class 晨跑 {
    public static void main(String[] args) {
        // 小蓝每周六、周日都晨跑，每月的 1、11、21、31日也晨跑。其它时间不晨跑。
        // 已知 2022年1月1日是周六，请问小蓝整个2022年晨跑多少天？
        Calendar c1 = Calendar.getInstance();
        int cnt = 0;
        c1.set(2022, Calendar.JANUARY, 1);
        System.out.println(c1.get(Calendar.DAY_OF_WEEK));
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
        while (c1.get(Calendar.YEAR) == 2022) {
            if (getVaild(c1)) ++cnt;
            c1.add(Calendar.DATE, 1);
        }
        System.out.println(cnt);
    }
    public static boolean getVaild(Calendar c){
        int week = c.get(Calendar.DAY_OF_WEEK), date = c.get(Calendar.DAY_OF_MONTH);
        return week == 7 || week == 1 || date == 1 || date == 11 || date == 21 || date == 31;
    }
}

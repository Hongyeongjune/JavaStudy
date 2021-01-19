package Java8.section5_Date와Time.Date와Time소개;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        // date 인데 time 을 뽑는 게 이상함.
        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);
        Thread.sleep(1000 * 3);
        Date after3Second = new Date();
        System.out.println(after3Second);
        after3Second.setTime(time);
        System.out.println(after3Second);

        // 12월을 표현하려면 11로 써야함
        Calendar hyjBirthDay = new GregorianCalendar(1995, Calendar.DECEMBER, 17);
        System.out.println(hyjBirthDay.getTime());
        hyjBirthDay.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(hyjBirthDay.getTime());

        // 기계용 시간
        Date date1 = new Date();
        long time1 = date.getTime();
        System.out.println(time);


    }
}

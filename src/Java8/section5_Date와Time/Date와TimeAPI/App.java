package Java8.section5_Date와Time.Date와TimeAPI;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {

    public static void main(String[] args) {
        // 현재 시간을 기계시간으로 출력
        Instant instant = Instant.now();
        // 기준시 UTC, GMT
        System.out.println(instant);
        System.out.println(instant.atZone(ZoneId.of("UTC")));

        // 내가 있는 곳 기준
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        // 사람시간으로 출력
        // 로컬을 기준으로
        // => 베포서버가 미국에 있다면 미국으로 찍힌다.
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthday =
                LocalDateTime.of(1995, Month.DECEMBER, 17, 0, 0, 0);
        System.out.println(birthday);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);

        // 사람용 기간을 표현하는 법
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021, Month.DECEMBER, 17);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        // 기계용 기간
        Instant now1 = Instant.now();
        Instant plus = now1.plus(10, ChronoUnit.SECONDS);
        Duration duration = Duration.between(now1, plus);
        System.out.println(duration.getSeconds());

        // Formatter
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(dateTimeFormatter));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        LocalDate parse = LocalDate.parse("12/17/1995", dateTimeFormatter);
        System.out.println(parse);

        // 레거시 API 지원
       Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ZonedDateTime dateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar.from(dateTime2);

        ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId1);
    }

}

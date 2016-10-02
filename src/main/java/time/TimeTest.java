package time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@SuppressWarnings("unused")
public class TimeTest {
	public static void testFormatter() {
		System.out.println(Instant.now().getEpochSecond());
		System.out.println(Instant.now().toString());
		
		LocalTime time = LocalTime.parse("20:56:06", DateTimeFormatter.ISO_TIME);
		System.out.println(time);
		System.out.println(time.getNano());
		
		LocalDate date = LocalDate.parse("20160229", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		LocalTime time2 = LocalTime.parse("105949087"
				, DateTimeFormatter.ofPattern("HHmmssSSS"));
		System.out.println(time2);
		
		LocalTime time3 = LocalTime.parse("090044002"
				, DateTimeFormatter.ofPattern("HHmmssSSS"));
		System.out.println(time3.format(DateTimeFormatter.ofPattern("HHmmssSSS")));
		
//		Timestamp t = new Timestamp(1456761667L);
//		Timestamp t = new Timestamp(1456761600040L);
		Timestamp t = new Timestamp(1468742700);
		System.out.println("t:" + t);
		
		Instant i = Instant.parse("2014-11-07T14:00:00.1234567Z");
		Date ldt = Date.from(i);
		System.out.println(ldt);
		
		String time4 = LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
		LocalDateTime ldt2 = LocalDateTime.parse(time4
				, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
		System.out.println(ldt2.toEpochSecond(ZoneOffset.ofHours(8)));
	}
	public static void main(String[] args) {
		testFormatter();
	}
}
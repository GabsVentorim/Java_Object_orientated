package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatterBuilder.html

		LocalDate d01 = LocalDate.parse("2022-07-20");
		LocalDateTime d02 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d03 = Instant.parse("2022-07-20T01:30:26Z");
		LocalDate d04 = LocalDate.now(); // now
		LocalDateTime d05 = LocalDateTime.now(); // now EX: 2023-01-26T13:13:49.989048100
		Instant d06 = Instant.now(); // now EX: 2023-01-26T16:13:49.989048100Z

		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

		LocalDate d07 = LocalDate.parse("20/07/2022", fmt1); // d07: 2022-07-20
		LocalDateTime d08 = LocalDateTime.parse("20/07/2022 01:30", fmt2); // d08: 2022-07-20T01:30
		LocalDate d09 = LocalDate.parse("22/01/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy")); // d09: 2023-01-22
		
		LocalDate d10 = LocalDate.of(2023, 1, 26); // d10: 2023-01-26
		LocalDateTime d11 = LocalDateTime.of(2022, 1, 26, 13, 14, 54); // d11: 2022-01-26T13:14:54
		
		LocalDate r1 = LocalDate.ofInstant(d03, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d03, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d03, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d03, ZoneId.of("Portugal"));

		LocalDate pastWeekLocalDate = d01.minusDays(7);
		LocalDate nextWeekLocalDate = d01.plusDays(7);

		LocalDateTime pastWeekLocalDateTime = d02.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d02.plusDays(7);

		Instant pastWeekInstant = d03.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d03.plus(7, ChronoUnit.DAYS);

		Duration t1 = Duration.between(pastWeekInstant, nextWeekInstant);
		// deve-se usar DateTime no duration, então tem de converter
		// atTime(0,0) ou atStartOfDay() -> coloca no começo do dia
		Duration t2 = Duration.between(pastWeekLocalDate.atTime(0, 0), d01.atStartOfDay());
		// do futuro pro passado o time fica negativo
		Duration t3 = Duration.between(nextWeekInstant, pastWeekInstant);
	}

}


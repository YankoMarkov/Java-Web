import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CountWorkingDays {
	
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String startDates = read.readLine();
		String endDates = read.readLine();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Calendar start = Calendar.getInstance();
		start.setTime(df.parse(startDates));
		Calendar end = Calendar.getInstance();
		end.setTime(df.parse(endDates));
		
		Date[] officialHolidays = addHolidays();
		int workingDaysCount = 0;
		
		while (!start.after(end)){
			int day = start.get(Calendar.DAY_OF_WEEK);
			
			if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
				start.add(Calendar.DAY_OF_MONTH, 1);
				continue;
			}
			boolean isHoliday = false;
			
			for (int i = 0; i < officialHolidays.length; i++) {
				Calendar checkHoliday = Calendar.getInstance();
				checkHoliday.setTime(officialHolidays[i]);
				int date1 = start.get(Calendar.DATE);
				int date2 = checkHoliday.get(Calendar.DATE);
				int month1 = start.get(Calendar.MONTH);
				int month2 = checkHoliday.get(Calendar.MONTH);
				if (date1 == date2 && month1 == month2) {
					isHoliday = true;
				}
			}
			if (!isHoliday) {
				workingDaysCount++;
			}
			start.add(Calendar.DAY_OF_MONTH, 1);
		}
		System.out.println(workingDaysCount);
	}
	
	private static Date[] addHolidays() {
		Date[] officialHolidays = new Date[]{
				new Date(2017, 1, 1),
				new Date(2017, 3, 3),
				new Date(2017, 5, 1),
				new Date(2017, 5, 6),
				new Date(2017, 5, 24),
				new Date(2017, 9, 6),
				new Date(2017, 9, 22),
				new Date(2017, 11, 1),
				new Date(2017, 12, 24),
				new Date(2017, 12, 25),
				new Date(2017, 12, 26)
		};
		return officialHolidays;
	}
}

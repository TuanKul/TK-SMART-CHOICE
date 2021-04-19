package net.kuleasycode.tksmartchoice.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {
	public static final String MY_TIME_ZONE = "Asia/Bangkok";
	
	public static final Pattern PATTERN_DATE = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)+$");
	public static final String PATTERN_TYPE_DATE = "date-type"; // dd/MM/yyyy
	public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
	
	public static final Pattern PATTERN_INTEGER = Pattern.compile("^[0-9]+$");
	
	public static final Pattern PATTERN_EMAIL = Pattern.compile("^[A-Z0-9._]+@[A-Z0-9.]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static Date parseDate(String strDate) {
		try {
            if (PATTERN_DATE.matcher(strDate).matches()) {
            	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            	df.setTimeZone(UTC_TIME_ZONE);
            	df.setLenient(false);
            	return df.parse(strDate);
            }
		} catch (ParseException e) {
            log.info("Parse String to Date");
        }
		return null;
	}
	
	public static boolean checkMatch(String type, String input){
		boolean matches = true;
		Matcher matcher;
		if (type.equals(PATTERN_TYPE_DATE)){
			matcher = PATTERN_DATE.matcher(input);
			matches = matcher.matches();
		}
		return matches;
	}
	
	public static boolean checkIntegerMatch(final String identity) {
		Matcher matcher = PATTERN_INTEGER.matcher(identity);
		return matcher.matches();
	}
	
	public static boolean checkMailMatch(final String mail) {
		Matcher matcher = PATTERN_EMAIL.matcher(mail);
		return matcher.matches();
	}
}

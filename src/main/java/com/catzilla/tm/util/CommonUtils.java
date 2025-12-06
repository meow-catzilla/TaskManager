package com.catzilla.tm.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

	public static String localDateTimeToString(LocalDateTime date) {
		return date !=null ? date.format(DateTimeFormatter.ISO_DATE_TIME): LocalDateTime.MIN.format(DateTimeFormatter.ISO_DATE_TIME); 
	}
}

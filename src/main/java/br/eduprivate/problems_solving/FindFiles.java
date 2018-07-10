package com.problems_solving;
//you can also use imports, for example:

import java.io.BufferedReader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class FindFiles {
 public String solution(String S) {

		BufferedReader bufferedReader = new BufferedReader(new StringReader(S));
		String record = null;
		int count = 0;
		try {
			while ((record = bufferedReader.readLine()) != null) {
				StringTokenizer tokens = new StringTokenizer(record);
				String name = tokens.nextToken();
				String size = tokens.nextToken();
				String day = tokens.nextToken();
				String month = tokens.nextToken();
				String year = tokens.nextToken();
				String file = tokens.nextToken();

				if (checkFileSize(size) && checkDate(day, month, year)) {
					count++;
				}
			}
		} catch (Exception e) {
		}

		if (count == 0) {
			return "NO FILES";
		} else {
			return String.valueOf(count);
		}
	}

	public boolean checkDate(String day, String month, String year) throws ParseException {

		String MAX_DATE_VALUE = "28/02/2000";
		Date MAX_DATE = new SimpleDateFormat("dd/MM/yyyy").parse(MAX_DATE_VALUE);

		String date = day + "/" + getMonth(month) + "/" + year;
		Date fileDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		return fileDate.before(MAX_DATE);

	}

	public Integer getMonth(String month) throws ParseException {
		Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return ( calendar.get(Calendar.MONTH) + 1 );
	}

	public boolean checkFileSize(String size) {
		long MAX_SIZE = 2097152l;
		long fileSize = fileSize(size);

		if (fileSize < MAX_SIZE) {
			return true;
		} else {
			return false;
		}
	}

	public long fileSize(String size) {
		long MEGA = 1024L * 1024L;
		long KILO = 1024L;

		if (size.contains("K")) {
			String byteSize = size.replace("K", "");
			long doubleByteSize = Long.parseLong(byteSize) * KILO;
			return doubleByteSize;
		} else if (size.contains("M")) {
			String byteSize = size.replace("M", "");
			long doubleByteSize = Long.parseLong(byteSize) * MEGA;
			return doubleByteSize;
		} else {
			long doubleByteSize = Long.parseLong(size);
			return doubleByteSize;
		}
	}
}

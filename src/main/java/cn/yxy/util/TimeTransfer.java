package cn.yxy.util;

import java.text.SimpleDateFormat;

public class TimeTransfer {
	public static String msToDate(long ms) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(ms);
		return date;
	}
}

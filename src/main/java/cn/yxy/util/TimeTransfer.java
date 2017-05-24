package cn.yxy.util;

import java.util.Date;

public class TimeTransfer {
	public static Date msToDate(long ms){
		Date date=new Date(ms);
		return date;
	}
}

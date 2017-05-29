package cn.yxy.util;

public class StringUtil {

	public static boolean isNotBlank(String str){
		boolean isNotBlank=(null!=str)&&(""!=str)&&(" "!=str);
		return isNotBlank;
	}
	
	public static void main(String[] args) {
		String str="sdsfa";
		System.out.println(isNotBlank(str));
	}
}

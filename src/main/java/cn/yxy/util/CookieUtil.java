package cn.yxy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		for (Cookie c : cookies) {
			if (c.getName().equals(cookieName)) {
				cookie = c;
			}
		}
		return cookie;
	}
}

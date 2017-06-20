package cn.yxy.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 从request中提取名为cookieName的cookie对象
 * <p>
 * return
 * 查询不到name时为null
 */
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

package cn.yxy.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.DESUtil;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return true;
		}

		Cookie[] cookies = request.getCookies();
		String tokenS = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("token")) {
				tokenS = c.getValue();
			}
		}

		if (tokenS != null) {
			String token = DESUtil.decrypt(tokenS, DESUtil.DES_KEY);
			String[] ts = token.split("-");
			long time = 0;
			if (ts[0].matches("[0-9]+") && ts[1].matches("[0-9]+")) {//TODO 此处若ts1不存在，可能是数组越界
				time = Long.parseLong(ts[1]);
			}

			long timeLeft = System.currentTimeMillis() - time - CookieConstantTable.COOKIE_MAX_AGE * 1000;
			if (timeLeft > 0 && time != 0) {
				return true;
			}
		}

		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}
}

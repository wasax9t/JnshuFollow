package cn.yxy.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.yxy.domain.User;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.DESUtil;

import java.util.Objects;

public class UserInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.debug("进入了拦截器");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        logger.debug("user:",user);
        if (user != null) {
            return true;
        }

        Cookie[] cookies = request.getCookies();
        String tokenS = null;
        for (Cookie c : cookies) {
            if ("token".equals(c.getName())) {
                tokenS = c.getValue();
            }
        }
        logger.debug("tokenS:",tokenS);
        logger.debug(null==tokenS);
        logger.debug(Objects.equals("", tokenS));
        logger.debug(Objects.equals(" ", tokenS));
        if (tokenS != null && !"".equals(tokenS) ) {
            String token = DESUtil.decrypt(tokenS, DESUtil.DES_KEY);
            logger.debug("token:",token);
            String[] ts = token.split("-");
            long time = 0;
            if (ts[0].matches("[0-9]+") && ts[1].matches("[0-9]+")) {//TODO 此处若ts1不存在，可能是数组越界
                time = Long.parseLong(ts[1]);
            }
            logger.debug("time:",time);
            long timeLeft = System.currentTimeMillis() - time - CookieConstantTable.COOKIE_MAX_AGE * 1000;
            logger.debug(timeLeft);
            if (timeLeft > 0 && time != 0) {
                logger.debug("这里回了");
                return true;
            }
        }
        logger.debug("到这不回去吗？");
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}

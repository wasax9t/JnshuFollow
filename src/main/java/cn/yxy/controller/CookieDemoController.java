package cn.yxy.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cookie")
public class CookieDemoController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView hello(@CookieValue(name="hitCounter",defaultValue="0")Long hitCounter,HttpServletResponse response){
		ModelAndView mAndView = new ModelAndView("cookieHello");
		
		hitCounter++;
		
		Cookie hit = new Cookie("hitCounter", hitCounter.toString());
		
		hit.setHttpOnly(true);  //如果设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法访问该Cookie
		hit.setMaxAge(60 * 60);  //设置生存期为1小时
//		hit.setDomain("www.zifansky.cn");  //子域，在这个子域下才可以访问该Cookie
//		hit.setPath("/hello");  //在这个路径下面的页面才可以访问该Cookie
//		hit.setSecure(true);  //如果设置了Secure，则只有当使用https协议连接时cookie才可以被页面访问
		response.addCookie(hit);
		return mAndView;
	}
}
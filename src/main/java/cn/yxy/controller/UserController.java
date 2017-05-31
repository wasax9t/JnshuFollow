package cn.yxy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.CookieUtil;
import cn.yxy.util.DESUtil;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户主页
	 */
	@RequestMapping("/u/home")
	public String userIndex() {
		return "jnshuUserHome";
	}

	/**
	 * 登录校验
	 */
	@RequestMapping("/doLogin")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam(name = "remember-me", required = false) boolean rememberMe, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User remoteUser = userService.selectByName(username);
		System.out.println(remoteUser);
		if (remoteUser == null) {
			// TODO 返回没有用户的一个参数，让js控制一句话显示或是弹窗
			System.out.println("用户不存在");
			return "redirect:login";
		}
		if (!remoteUser.getPassword().equals(password)) {
			// TODO 密码错误
			System.out.println("密码错误");
			System.out.println(remoteUser.getPassword());
			System.out.println(password);
			return "redirect:login";
		}
		if (rememberMe == true) {
			long id = remoteUser.getId();
			long nowTime = System.currentTimeMillis();
			String data = id + "-" + nowTime;
			System.out.println("data:" + data);
			String token = DESUtil.encrypt(data, DESUtil.DES_KEY);
			System.out.println("token:" + token);
			Cookie cookie = new Cookie("token", token);
			cookie.setMaxAge(CookieConstantTable.COOKIE_MAX_AGE);
			response.addCookie(cookie);
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", remoteUser);
		model.addAttribute("user", remoteUser);
		return "redirect:/u/home";
	}

	@RequestMapping("/doRegister")
	public String checkRegister(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, Model model) {
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setEmail(email);
		// TODO username重复
		user.setCreateAt(System.currentTimeMillis());
		userService.insert(user);
		model.addAttribute("message", username);
		return "jnshuRAfter";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
//		Cookie ck=CookieUtil.getCookie(request, "token");
//		ck.setMaxAge(0);
//		ck.setValue(null);
//		response.addCookie(ck);
		return "redirect:login";
	}
}

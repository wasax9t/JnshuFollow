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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.CookieUtil;
import cn.yxy.util.DESUtil;
import cn.yxy.util.EncryptionUtil;

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
			HttpServletResponse response, RedirectAttributes redierctAttr) {
		User remoteUser = userService.selectByName(username);
		System.out.println(remoteUser);
		if (remoteUser == null) {
			// TODO 返回没有用户的一个参数，让js控制一句话显示或是弹窗
			System.out.println("用户不存在");
			return "redirect:login";
		}
		String MD5password = EncryptionUtil.md5Hex(username+password);
		if (!remoteUser.getPassword().equals(MD5password)) {
			// TODO 密码错误
			System.out.println("密码错误");
//			System.out.println(remoteUser.getPassword());
//			System.out.println(password);
			return "redirect:login";
		}
		if (rememberMe == true) {
			long id = remoteUser.getId();
			long nowTime = System.currentTimeMillis();
			String data = id + "-" + nowTime;
			String token = DESUtil.encrypt(data, DESUtil.DES_KEY);
//			System.out.println("data:" + data);
//			System.out.println("token:" + token);
			Cookie cookie = new Cookie("token", token);
			cookie.setMaxAge(CookieConstantTable.COOKIE_MAX_AGE);
			response.addCookie(cookie);
			redierctAttr.addFlashAttribute("user", remoteUser);

		}else{
			HttpSession session = request.getSession();
			session.setAttribute("user", remoteUser);
		}
		return "redirect:/u/home";
	}

	/**
	 * 注册校检
	 * @param username
	 * @param password
	 * @param email
	 * @param model
	 * 			为了给页面传用户名
	 * @return 一个注册成功的页面
	 */
	@RequestMapping("/doRegister")
	public String checkRegister(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("email") String email, Model model) {
		User user = new User();
		user.setName(username);
		String MD5password = EncryptionUtil.md5Hex(username+password);
		user.setPassword(MD5password);
		user.setEmail(email);
		// TODO username重复
		user.setCreateAt(System.currentTimeMillis());
		userService.insert(user);
		model.addAttribute("username", username);
		return "jnshuRAfter";
	}

	/**
	 * 登出执行，注销session和cookie
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		Cookie ck=CookieUtil.getCookie(request, "token");
		if(ck != null){
			ck.setMaxAge(0);
			ck.setValue(null);
			response.addCookie(ck);
		}
		return "redirect:login";
	}
}

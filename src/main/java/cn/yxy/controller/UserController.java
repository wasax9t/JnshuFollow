package cn.yxy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.StringUtil;

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
     * 登录校验 有待进一步理解
     */
	@RequestMapping("/check")
	public String checkUser(){
		
		
		return "jnshuUserHome";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		
		
		return "jnshuLogin";
	}
}

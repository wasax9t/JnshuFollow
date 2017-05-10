package cn.yxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentTableController {
	
	@Autowired
	private StudentService ss;

	@RequestMapping
	public String stuHome(Model model){
		model.addAttribute("message", "这是一个student表的主页，可能在将来提供一些链接");
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginAfter(Model model,Student stu){
		long id = ss.login(stu);
		model.addAttribute("message", "注册成功了吧，你的ID是："+id);
		return "home";
	}
}

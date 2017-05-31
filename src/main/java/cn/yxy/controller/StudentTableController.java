package cn.yxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxy.aoplog.RequiredTS;
import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentTableController {

	@Autowired
	private StudentService studentService;

	@RequiredTS
	@RequestMapping(method = RequestMethod.GET)
	public String stuHome(Model model) {
		model.addAttribute("message", "这是一个student表的主页，可能在将来提供一些链接");
		return "student/home";
	}

	@RequiredTS
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String loginController(Model model, @RequestBody Student stu) {
		long id = studentService.insert(stu);
		model.addAttribute("message", "注册成功了吧，你的ID是：" + id);
		return "student/home";
	}

	@RequiredTS
	@RequestMapping(value = "/u/{id}", method = RequestMethod.GET)
	public @ResponseBody Student getController(@PathVariable long id) {
		Student stu = studentService.get(id);
		return stu;
	}

	@RequiredTS
	@RequestMapping(value = "/u/{id}", method = RequestMethod.DELETE)
	public String deleteController(Model model, @PathVariable long id) {
		boolean tf = studentService.delete(id);
		model.addAttribute("message", id + "删了吗" + tf);
		return "student/home";
	}

	@RequiredTS
	@RequestMapping(value = "/u", method = RequestMethod.PUT)
	public String updateController(Model model, @RequestBody Student stu) {
		boolean tf = studentService.update(stu);
		model.addAttribute("message", stu.getid() + "更新了吗" + tf);
		return "home";
	}
}

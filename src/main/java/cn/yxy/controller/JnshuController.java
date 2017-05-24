package cn.yxy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;

@Controller
@RequestMapping("/")
public class JnshuController {
	
	@Autowired
	private StudentService studentService;
 
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
    	List<Student> list = new ArrayList<Student>();
    	list.add(studentService.get(1));
    	list.add(studentService.get(2));
    	list.add(studentService.get(3));
    	list.add(studentService.get(4));
    	model.addAttribute("studentList", list);
        return "jnshuIndex";
    }
 
    @RequestMapping(value = { "/profession"}, method = RequestMethod.GET)
    public String professionPage(ModelMap model) {
        return "jnshuProfession";
    }
    
    @RequestMapping(value = { "/time"}, method = RequestMethod.GET)
    public String timePage(ModelMap model) {
        return "jnshuTime";
    }
}
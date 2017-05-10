package cn.yxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yxy.domain.Student;

@Controller
@RequestMapping
public class HomePage {
    @RequestMapping
    public String SayHi(Model model,Student stu) {
        model.addAttribute("message", stu);
        return "student/home";
    }
}
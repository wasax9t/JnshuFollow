package cn.yxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomePage {
    @RequestMapping
    public String SayHi(Model model) {
        model.addAttribute("message", "这是jnshudemo的主页");
        return "jnhome";
    }
}
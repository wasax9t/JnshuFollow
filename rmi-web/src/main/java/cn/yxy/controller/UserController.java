package cn.yxy.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.CookieUtil;
import cn.yxy.util.DESUtil;
import cn.yxy.util.EncryptionUtil;

@Controller
public class UserController {

    @Resource(name="userService1")
    private UserService userService;

    /**
     * 一个不用tiles，用来压力测试的假页面
     */
    @RequestMapping("/cachetest")
    public String cacheTest(Model model) {
        Random random = new Random(System.currentTimeMillis());
        long id = random.nextInt(9);
        if (id == 5 || id == 6 || id == 0) {
            id = 8;
        }
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "cacheTest";
    }
}

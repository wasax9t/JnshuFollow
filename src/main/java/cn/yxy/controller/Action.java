package cn.yxy.controller;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxy.util.CCPSDKUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/action")
public class Action {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/verificationCode", method = RequestMethod.POST)
    @ResponseBody
    public boolean verificationCode(String phoneNumber, HttpServletRequest request) {

        System.out.println("接收到手机号：" + phoneNumber + " 但并用不了");
        String code = MathUtil.getRandomNumber(6);
        System.out.println("code:"+code);
        int expiration = 2;
        HttpSession session=request.getSession();
        session.setAttribute("code", code);
        session.setMaxInactiveInterval(expiration*60+5);
//        boolean re = CCPSDKUtil.sendVerificationCode("18854508212", code, Integer.toString(expiration));
        if (true) return true;
        else return false;
    }

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkUsername(String username){
        User user = userService.selectByName(username);
        System.out.println(user);
        if(user != null){
            return false;
        }else{
            return true;
        }
    }
}
package cn.yxy.controller;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import cn.yxy.util.IPDefence;
import cn.yxy.util.MathUtil;
import cn.yxy.util.api.AliyunOSS;
import cn.yxy.util.api.QiniuToken;
import cn.yxy.util.api.SendCloudAPI;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxy.util.api.CCPSDKUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/action")
public class Action {

    @Autowired
    private UserService userService;

    @Autowired
    private IPDefence ipDefence;

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
        boolean re = CCPSDKUtil.sendVerificationCode("18854508212", code, Integer.toString(expiration));
        if (re) return true;
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

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public String sendEmail(String email, HttpServletRequest request) throws IOException {
        System.out.println("点击");
        if (!ipDefence.check(request)) {
            return "请求次数过多";
        }
        String re= SendCloudAPI.send_common(email);
        return re;
    }

//    @Autowired
//    QiniuToken qiniuToken;

    @RequestMapping(value = "/qiniuToken")
    @ResponseBody
    public String qiniuToken() {

        String re= QiniuToken.getUpToken();
        return re;
    }

    @RequestMapping(value = "/aliyunOSS")
    @ResponseBody
    public String aliyunOSS() {
        String etag = AliyunOSS.putFile("testFile.png", new File("E:\\Pictures\\20170318.png"));
        return etag;
    }
}

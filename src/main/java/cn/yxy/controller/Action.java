package cn.yxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yxy.util.CCPSDKUtil;

@Controller
@RequestMapping("/action")
public class Action {

	@RequestMapping(value="/verificationCode", method = RequestMethod.POST)
	@ResponseBody
	public boolean verificationCode(long phoneNumble){
		
		System.out.println("接收到手机号："+phoneNumble+" 但并用不了");
		int code=123456;
		int expiration=2;
		boolean re = CCPSDKUtil.sendVerificationCode("18854508212", Integer.toString(code), Integer.toString(expiration));
		return re;
	}
}

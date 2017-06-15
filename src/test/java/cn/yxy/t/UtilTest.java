package cn.yxy.t;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.util.CCPSDKUtil;

public class UtilTest extends BaseTest {

//	@Autowired
//	private CCPSDKUtil csu;

    @Test
    public void ccpTest() {
        CCPSDKUtil.sendVerificationCode("18854508212", "123456", "2");

    }
}

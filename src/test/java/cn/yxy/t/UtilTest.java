package cn.yxy.t;

import org.junit.Test;

import cn.yxy.util.api.CCPSDKUtil;

public class UtilTest extends BaseTest {

//	@Autowired
//	private CCPSDKUtil csu;

    @Test
    public void ccpTest() {
        CCPSDKUtil.sendVerificationCode("18854508212", "123456", "2");

    }
}

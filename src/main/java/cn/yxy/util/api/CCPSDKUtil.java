package cn.yxy.util.api;

import java.util.HashMap;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.cloopen.rest.sdk.CCPRestSDK;

public class CCPSDKUtil {
    private static Logger logger = LogManager.getLogger(CCPSDKUtil.class);

    private final static String SERVER_IP = "app.cloopen.com";
    private final static String SERVER_PORT = "8883";

    private String accountSid;
    private String authToken;

    private String appId;
    private static CCPRestSDK restAPI;

    @PostConstruct
    public void init() {
        restAPI = new CCPRestSDK();
        restAPI.init(SERVER_IP, SERVER_PORT);
        restAPI.setAccount(accountSid, authToken);
        restAPI.setAppId(appId);
//        System.out.println("初始化完成CCP-SDK");
    }

    public static boolean sendVerificationCode(String phoneNumble, String placeH1, String placeH2) {
        HashMap<String, Object> result;
        String[] datas = new String[]{placeH1, placeH2};
        result = restAPI.sendTemplateSMS(phoneNumble, "1", datas);
        if ("000000".equals(result.get("statusCode"))) {
            // 正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                logger.trace(key + " = " + object);
            }
            return true;
        } else {
            // 异常返回输出错误码和错误信息
            logger.warn("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            return false;
        }
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}

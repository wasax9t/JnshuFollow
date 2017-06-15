package cn.yxy.util.api;

import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Administrator on 2017/6/13.
 */
@Component
public class QiniuToken {

    private String accessKey;
    private String secretKey;

    static String bucketname="qiniu-was";
    static Auth auth;
//    static Auth auth=Auth.create("XWS2jhA5QUAABgcZcizWu_vTfTWSmJB_5YQXx79Z","tGDl9ZniWrSQPfJmx8Ht0VdLZe6j7K3B-DRj7hgb");

//    public QiniuToken() {}
//    public QiniuToken(String s1, String s2) {}

    @PostConstruct
    public void init(){
        System.out.println("不进来");
        auth = Auth.create(accessKey,secretKey);
    }

    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }


    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public static void main(String[] args) {
        System.out.println(QiniuToken.getUpToken());
    }
}

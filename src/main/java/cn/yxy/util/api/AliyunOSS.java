package cn.yxy.util.api;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Created by Administrator on 2017/6/15.
 */
public class AliyunOSS {
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }
    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;

    private static OSSClient ossClient;

    @PostConstruct
    public void init(){
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    public static OSSClient getOssClient() {
        return ossClient;
    }

    /**
     *
     * @param name  存到服务器的名字
     * @param file  要上传的文件路径
     * @return  ETag
     */
    public static String putFile(String name, File file){
        PutObjectResult result = ossClient.putObject("aliyun-was", name, file);
        ossClient.shutdown();
        return result.getETag();
    }
}

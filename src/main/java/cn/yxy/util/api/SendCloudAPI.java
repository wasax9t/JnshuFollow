package cn.yxy.util.api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

@Component
public class SendCloudAPI {

    private String apiUser;
    private String apiKey;
    final static String url = "http://api.sendcloud.net/apiv2/mail/send";

    static List<NameValuePair> params = new ArrayList<NameValuePair>();
    static HttpPost httpPost = new HttpPost(url);
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    @PostConstruct
    public void init(){
//        httpPost;
//        httpClient;
        params.add(new BasicNameValuePair("apiUser", apiUser));
        params.add(new BasicNameValuePair("apiKey", apiKey));
        System.out.println("初始化完成SendCloud");
    }

    public static String send_common(String email) throws IOException {

        final String rcpt_to = email;

        String subject = "我是标题";//标题
        String html = "...";//邮件内容 text/html

        params.add(new BasicNameValuePair("to", rcpt_to));
        params.add(new BasicNameValuePair("from", "sendcloud@sendcloud.org"));
        params.add(new BasicNameValuePair("fromName", "SendCloud"));
        params.add(new BasicNameValuePair("subject", subject));
        params.add(new BasicNameValuePair("html", html));

        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpClient.execute(httpPost);

        String re="未发送成功";
        // 处理响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 正常返回, 解析返回数据
            re = EntityUtils.toString(response.getEntity());
        } else {
            System.err.println("error");
        }
        httpPost.releaseConnection();
        return re;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(params);
        System.out.println(httpPost);
        System.out.println(httpClient);
        String re = send_common("wasax9t@126.com");
        System.out.println(re);
    }

    public void setApiUser(String apiUser) {
        this.apiUser = apiUser;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}

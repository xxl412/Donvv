package com.donvv.logintest.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@CrossOrigin
public class LoginController {

    private final OkHttpClient client = new OkHttpClient();

    @RequestMapping("/hi")
    public String test() {
        return "123";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name = "code") String code) throws URISyntaxException, IOException {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxe3003cdea506a0c8&secret=74471ca1887b81df5f15a3295e964f81&code=" + code + "&grant_type=authorization_code";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建一个GET对象
        HttpGet get = new HttpGet(url);

        //执行请求
        CloseableHttpResponse response = httpClient.execute(get);

        //取响应的结果
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        HttpEntity entity = response.getEntity();

        String string = EntityUtils.toString(entity, "utf-8");

        //关闭httpclient
        response.close();

        httpClient.close();

        return string;
    }
}

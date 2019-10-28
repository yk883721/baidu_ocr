package com.yk.baiduocr.controller;

import com.baidu.aip.ocr.AipOcr;
import jdk.internal.util.xml.impl.Input;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
public class controller {

    //设置APPID/AK/SK
    public static final String APP_ID = "";
    public static final String API_KEY = "";
    public static final String SECRET_KEY = "";

    @ResponseBody
    @RequestMapping(value = "upload",produces = "application/json;charset=UTF-8")
    public String uploadImg(MultipartFile file){
//        InputStream is = ;



        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
//        String path = "test.jpg";
        JSONObject res = null;
        try {
            res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString(2);
    }
}

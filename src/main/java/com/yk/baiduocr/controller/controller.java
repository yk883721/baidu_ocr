package com.yk.baiduocr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {

    @ResponseBody
    @RequestMapping("upload")
    public String uploadImg(){
        return "你好啊";
    }
}

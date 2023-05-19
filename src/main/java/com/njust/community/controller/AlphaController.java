package com.njust.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zhangpeng
 * @Date 2023/5/4 16:56
 * @PackageName:com.njust.community.controller
 * @ClassName: AlphaController
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot.";
    }
}

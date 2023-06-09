package com.njust.community.controller;

import com.njust.community.entity.DiscussPost;
import com.njust.community.entity.Page;
import com.njust.community.entity.User;
import com.njust.community.service.DiscussPostService;
import com.njust.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangpeng
 * @Date 2023/5/16 15:47
 * @PackageName:com.njust.community.controller
 * @ClassName: HomeController
 * @Description: TODO
 * @Version 1.0
 */
@Controller
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {

        //方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model；
        //所以，在thymeleaf中可以直接访问Page对象中的数据。

        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> discussPostList = discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());

        List<Map<String, Object>> discussPosts = new ArrayList<>();

        if (discussPostList != null) {
            for (DiscussPost post : discussPostList) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

}

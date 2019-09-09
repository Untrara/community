package edu.swpu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 允许这个类去接受前端的请求
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name ="name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";//自动去resources下面的templates寻找hello模板
    }
}

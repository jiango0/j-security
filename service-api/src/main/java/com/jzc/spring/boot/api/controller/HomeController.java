package com.jzc.spring.boot.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "")
    public String helloWorld() {
        return "hello world";
    }

}

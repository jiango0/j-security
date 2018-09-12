package com.jzc.spring.boot.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("secure")
public class SecureController {

    @ResponseBody
    @RequestMapping(value = "")
    public String hello() {
        return "hello world";
    }

}

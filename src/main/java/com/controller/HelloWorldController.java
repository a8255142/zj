package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.HelloWorld;

@Controller
public class HelloWorldController
{
    @Autowired
    HelloWorld helloWorld;
    
    @RequestMapping("/hello.do")
    public String hello(Model model)
    {
        
        model.addAttribute("greeting", "Hello Spring MVC");
        helloWorld.sayHello();
        return "helloworld";
        
    }
}

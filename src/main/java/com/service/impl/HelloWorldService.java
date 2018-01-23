package com.service.impl;

import org.springframework.stereotype.Service;

import com.service.HelloWorld;

@Service
public class HelloWorldService implements HelloWorld
{
    
    public void sayHello()
    {
        System.out.println("hello!!");
    }
    
}

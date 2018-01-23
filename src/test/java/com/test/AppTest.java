package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model.TUser;
import com.service.ITestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/applicationContext.xml"})
public class AppTest
{
    
    @SuppressWarnings("unused")
    @Autowired
    private ITestService service;
    
    @Test
    public void test()
    {
        try
        {
            TUser tUser = new TUser();
            //service.insertUser(tUser);
            System.out.println("------------");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}

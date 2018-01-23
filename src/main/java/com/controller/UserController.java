package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.InsertUserReq;
import com.model.SearchUserReq;
import com.model.TUser;
import com.model.UpdateUserReq;
import com.model.resp.FindUserListResp;
import com.service.ITestService;

@Controller
public class UserController
{
    @Autowired
    private ITestService service;
    
    @RequestMapping("/page.do")
    public Object findUser(Model model, SearchUserReq req)
        throws Exception
    {
        HashMap<String, Object> data = new HashMap<>();
        if (!StringUtils.isEmpty(req.getAccount()))
        {
            
            TUser user = service.findCurrUser(req);
            if (user != null)
            {
                data.put("nowUser", user);
                TUser pUser = new TUser();
                pUser.setUserId(user.getPid());
                List<TUser> list = service.findChildUser(user);
                data.put("childList", list);
                if (!StringUtils.isEmpty(user.getPid()))
                {
                    pUser = service.findUser(pUser);
                    data.put("pUser", pUser);
                }
                if (list != null && !list.isEmpty())
                {
                    List<TUser> childList1 = service.findChildUsers(list);
                    data.put("childList1", childList1);
                    if (childList1 != null && !childList1.isEmpty())
                    {
                        List<TUser> childList2 = service.findChildUsers(childList1);
                        data.put("childList2", childList2);
                    }
                    
                }
                
            }
        }
        model.addAttribute("data", data);
        return "helloworld";
        
    }
    
    @RequestMapping("/allUser.do")
    public Object findAllUser(Model model, SearchUserReq req)
        throws Exception
    {
        List<FindUserListResp> list = service.findAllUserList(req);
        model.addAttribute("data", list);
        return "allUser";
    }
    
    @RequestMapping(value = "/insert.do", method = RequestMethod.POST, produces = {"application/json",
        "application/xml"})
    @ResponseBody
    public Map<String, Object> insert(Model model, InsertUserReq req)
        throws Exception
    {
        HashMap<String, Object> data = new HashMap<>();
        String pUserId = null;
        //有父级
        if (!StringUtils.isEmpty(req.getpCardnum()))
        {
            TUser pUser = new TUser();
            pUser.setCardnum(req.getpCardnum());
            List<TUser> list = service.findTUser(pUser);
            if (list == null || list.size() == 0)
            {
                data.put("code", "1");
                data.put("Msg", "不存在的上级！！");
                return data;
            }
            else
            {
                pUserId = list.get(0).getUserId();
            }
        }
        TUser tUser = new TUser();
        tUser.setCardnum(req.getCardnum());
        //身份证存在判断
        TUser pUser = new TUser();
        pUser.setCardnum(req.getCardnum());
        List<TUser> list = service.findTUser(pUser);
        if (list == null || list.size() == 0)
        {
        
        }
        else
        {
            data.put("code", "1");
            data.put("Msg", "身份已经存在！！");
            return data;
        }
        
        tUser.setName(req.getName());
        tUser.setPid(pUserId);
        service.insertUser(tUser);
        data.put("code", "0");
        data.put("Msg", "添加人员成功！！");
        return data;
        
    }
    
    @RequestMapping(value = "/update.do", method = RequestMethod.POST, produces = {"application/json",
        "application/xml"})
    @ResponseBody
    public Map<String, Object> updateUser(UpdateUserReq req)
        throws Exception
    {
        HashMap<String, Object> data = new HashMap<>();
        String pUserId = null;
        TUser tUser = new TUser();
        
        //有父级
        if (!StringUtils.isEmpty(req.getpCardnum()))
        {
            TUser pUser = new TUser();
            pUser.setCardnum(req.getpCardnum());
            List<TUser> list = service.findTUser(pUser);
            if (list == null || list.size() == 0)
            {
                data.put("code", "1");
                data.put("Msg", "不存在的父级！！");
                return data;
            }
            else
            {
                pUserId = list.get(0).getUserId();
            }
        }
        tUser.setUserId(req.getUserId());
        tUser = service.findUser(tUser);
        if (!tUser.getCardnum().equals(req.getCardnum()))
        {
            tUser = new TUser();
            tUser.setCardnum(req.getCardnum());
            //身份证存在判断
            TUser pUser = new TUser();
            pUser.setCardnum(req.getCardnum());
            List<TUser> list = service.findTUser(pUser);
            if (list == null || list.size() == 0)
            {
            
            }
            else
            {
                data.put("code", "1");
                data.put("Msg", "身份已经存在！！");
                return data;
            }
        }
        tUser.setUserId(req.getUserId());
        tUser.setName(req.getName());
        tUser.setPid(pUserId);
        service.updateUser(tUser);
        data.put("code", "0");
        data.put("Msg", "更新人员成功！！");
        return data;
        
    }
    
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST, produces = {"application/json",
        "application/xml"})
    @ResponseBody
    public Map<String, Object> deleteUser(TUser req)
        throws Exception
    {
        HashMap<String, Object> data = new HashMap<>();
        service.deleteUser(req);
        data.put("code", "0");
        data.put("Msg", "删除人员成功！！");
        return data;
        
    }
}

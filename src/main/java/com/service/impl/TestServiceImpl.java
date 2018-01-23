package com.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.model.SearchUserReq;
import com.model.TUser;
import com.model.resp.FindUserListResp;
import com.service.ITestService;
import com.service.common.impl.BaseServiceImpl;
import com.service.common.impl.QueryEvent;

@Service
public class TestServiceImpl extends BaseServiceImpl implements ITestService
{
    
    public void insertUser(TUser tUser)
        throws Exception
    {
        //System.out.println(TestServiceImpl.class.getResource("/").getPath());
        Random random = new Random(new java.util.Date().getTime());
        String id = String.valueOf(new java.util.Date().getTime()) + Math.abs(random.nextInt(9999));
        tUser.setUserId(id);
        tUser.setCreateTime(new Date());
        int i = baseDao.insert(tUser);
        System.out.println("成功------------:" + i);
    }
    
    @Override
    public void updateUser(TUser tUser)
        throws Exception
    {
        baseDao.update(tUser);
        
    }
    
    @Override
    public void deleteUser(TUser tUser)
        throws Exception
    {
        baseDao.delete(tUser);
    }
    
    @Override
    public TUser findUser(TUser tUser)
        throws Exception
    {
        QueryEvent<TUser> event = new QueryEvent<>();
        event.setObj(tUser);
        event.setStatement("findUser");
        tUser = (TUser)baseDao.findOneByCustom(event);
        return tUser;
        
    }
    
    @Override
    public TUser findCurrUser(SearchUserReq req)
        throws Exception
    {
        QueryEvent<SearchUserReq> event = new QueryEvent<>();
        event.setObj(req);
        event.setStatement("findCurrUser");
        TUser tUser = (TUser)baseDao.findOneByCustom(event);
        return tUser;
        
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> findChildUser(TUser tUser)
        throws Exception
    {
        QueryEvent<TUser> event = new QueryEvent<>();
        event.setObj(tUser);
        event.setStatement("findChildUser");
        return baseDao.findAllIsPageByCustom(event);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> findTUser(TUser tUser)
        throws Exception
    {
        QueryEvent<TUser> event = new QueryEvent<>();
        event.setObj(tUser);
        event.setStatement("findTUser");
        return baseDao.findAllIsPageByCustom(event);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TUser> findChildUsers(List<TUser> list)
        throws Exception
    {
        QueryEvent<TUser> event = new QueryEvent<>();
        event.putParameter("ids", list);
        event.setStatement("findChildUsers");
        return baseDao.findAllIsPageByCustom(event);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FindUserListResp> findAllUserList(SearchUserReq req)
        throws Exception
    {
        QueryEvent<SearchUserReq> event = new QueryEvent<>();
        event.setObj(req);
        event.setStatement("findAllUserList");
        List<FindUserListResp> list = baseDao.findAllIsPageByCustom(event);
        return list;
    }
}

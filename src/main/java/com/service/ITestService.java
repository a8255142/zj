package com.service;

import java.util.List;

import com.model.SearchUserReq;
import com.model.TUser;
import com.model.resp.FindUserListResp;

public interface ITestService
{
    /**
     * 插入
     * 
     * @throws Exception
     */
    public void insertUser(TUser tUser)
        throws Exception;
        
    /**
     * 修改
     * @throws Exception
     */
    public void updateUser(TUser tUser)
        throws Exception;
        
    /**
     * 删除
     * @throws Exception
     */
    public void deleteUser(TUser tUser)
        throws Exception;
        
    /**
     * 查询单个
     * <功能详细描述>
     * @author  zhangjian
     * @param tUser
     * @return
     * @throws Exception
     */
    TUser findUser(TUser tUser)
        throws Exception;
        
    List<TUser> findTUser(TUser tUser)
        throws Exception;
        
    /**
     * 按父级查询多个子级
     * <功能详细描述>
     * @author  zhangjian
     * @param tUser
     * @return
     * @throws Exception
     */
    List<TUser> findChildUser(TUser tUser)
        throws Exception;
        
    /**
     * 按多个父级查询多个子级
     * <功能详细描述>
     * @author  zhangjian
     * @param tUser
     * @return
     * @throws Exception
     */
    List<TUser> findChildUsers(List<TUser> list)
        throws Exception;
        
    /**
     * 查询当前用户
     * <功能详细描述>
     * @author  zhangjian
     * @param tUser
     * @return
     * @throws Exception
     */
    public TUser findCurrUser(SearchUserReq tUser)
        throws Exception;
        
    /**
     * 查询所有用户
     * <功能详细描述>
     * @author  zhangjian
     * @param tUser
     * @return
     * @throws Exception
     */
    public List<FindUserListResp> findAllUserList(SearchUserReq req)
        throws Exception;
        
}

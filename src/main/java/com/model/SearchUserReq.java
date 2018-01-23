package com.model;

import java.io.Serializable;

/***
 * 
 * 查询
 * <功能详细描述>
 * 
 * @author  zhangjian
 * @version  [版本号, 2017年3月24日]
 */
public class SearchUserReq implements Serializable
{
    
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -5742550292859930530L;
    
    /**
     * 身份证或姓名
     */
    private String account;
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        this.account = account;
    }
    
}

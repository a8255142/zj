package com.model;

import java.util.Date;

public class TUser
{
    /**
     * 
     */
    private String userId;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 身份证
     */
    private String cardnum;
    
    /**
     * 父级ID
     */
    private String pid;
    
    /**
     * 级别
     */
    private String lev;
    
    /**
     * 
     */
    private Date createTime;
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCardnum()
    {
        return cardnum;
    }
    
    public void setCardnum(String cardnum)
    {
        this.cardnum = cardnum;
    }
    
    public String getPid()
    {
        return pid;
    }
    
    public void setPid(String pid)
    {
        this.pid = pid;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public String getLev()
    {
        return lev;
    }
    
    public void setLev(String lev)
    {
        this.lev = lev;
    }
    
}
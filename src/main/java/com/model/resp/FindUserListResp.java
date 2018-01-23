package com.model.resp;

public class FindUserListResp
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
     * 父级名称
     */
    private String pName;
    
    /**
     * 
     */
    private String createTime;
    
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
    
    public String getpName()
    {
        return pName;
    }
    
    public void setpName(String pName)
    {
        this.pName = pName;
    }
    
    public String getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }
    
}
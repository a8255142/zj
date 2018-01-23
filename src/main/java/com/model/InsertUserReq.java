package com.model;

import java.io.Serializable;

public class InsertUserReq implements Serializable
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 7981102939261407267L;
    
    /**
     * 父级身份证
     */
    private String pCardnum;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 身份证
     */
    private String cardnum;
    
    public String getpCardnum()
    {
        return pCardnum;
    }
    
    public void setpCardnum(String pCardnum)
    {
        this.pCardnum = pCardnum;
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
    
}

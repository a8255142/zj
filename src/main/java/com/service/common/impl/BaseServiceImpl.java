package com.service.common.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.common.IBaseDao;
import com.service.common.IBaseService;

public class BaseServiceImpl implements IBaseService
{
    
    @Autowired
    protected IBaseDao baseDao;
}

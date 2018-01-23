package com.service.common;

import java.util.List;

import com.service.common.impl.QueryEvent;

public interface IBaseDao
{
    public abstract int insert(Object obj);
    
    public abstract Object findById(Object obj);
    
    public abstract int update(Object obj);
    
    public abstract int delete(Object obj);
    
    @SuppressWarnings("rawtypes")
    public abstract List findAllIsPageByCustom(QueryEvent queryevent);
    
    @SuppressWarnings("rawtypes")
    public abstract Object findOneByCustom(QueryEvent queryevent);
}

package com.service.common.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.service.common.IBaseDao;

public class BaseDaoImpl implements IBaseDao
{
    private transient SqlSession sqlSession;
    
    private transient SqlSessionFactory sessionFactory;
    
    public BaseDaoImpl()
    {
    }
    
    public SqlSessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    public void setSessionFactory(SqlSessionFactory sessionFactorys)
    {
        sessionFactory = sessionFactorys;
    }
    
    public void setSqlSessionTemplate(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }
    
    public SqlSession getSqlSessionTemplate()
    {
        return sqlSession;
    }
    
    public Object findById(Object obj)
    {
        return getSqlSessionTemplate().selectOne(getSQLName("findById", obj), obj);
    }
    
    public static String getSQLName(String order, Object obj)
    {
        StringBuffer sql = new StringBuffer();
        sql.append(order);
        sql.append(obj.getClass().getSimpleName());
        return sql.toString();
    }
    
    public int insert(Object obj)
    {
        SqlSession session = getSqlSessionTemplate();
        return session.insert(getSQLName("insert", obj), obj);
    }
    
    public int delete(Object obj)
    {
        return getSqlSessionTemplate().delete(getSQLName("delete", obj), obj);
    }
    
    public int update(Object obj)
    {
        return getSqlSessionTemplate().update(getSQLName("update", obj), obj);
    }
    
    @SuppressWarnings("rawtypes")
    public List findAllIsPageByCustom(QueryEvent event)
    {
        event.initParameter();
        List object;
        if (null == event.getStatement() || "".equals(event.getStatement()))
            object = getSqlSessionTemplate().selectList(getSQLName("findAll", event.getObj()), event.getParameter());
        else
            object = getSqlSessionTemplate().selectList(event.getStatement(), event.getParameter());
        return object;
    }
    
    public Object findOneByCustom(QueryEvent event)
    {
        event.initParameter();
        Object object = getSqlSessionTemplate().selectOne(event.getStatement(), event.getParameter());
        return object;
    }
}

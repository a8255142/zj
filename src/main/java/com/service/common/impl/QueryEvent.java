package com.service.common.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class QueryEvent<T>
{
    private T obj;
    
    private String statement;
    
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Map<String, Object> parameter = new HashMap();
    
    private String appendSql;
    
    public String getStatement()
    {
        return this.statement;
    }
    
    public void setStatement(String statement)
    {
        this.statement = statement;
    }
    
    public Map<String, Object> getParameter()
    {
        return this.parameter;
    }
    
    public void setParameter(Map<String, Object> parameter)
    {
        this.parameter = parameter;
    }
    
    public T getObj()
    {
        return this.obj;
    }
    
    public void setObj(T obj)
    {
        this.obj = obj;
    }
    
    public String getAppendSql()
    {
        return this.appendSql;
    }
    
    public void setAppendSql(String appendSql)
    {
        this.appendSql = appendSql;
    }
    
    @SuppressWarnings("rawtypes")
    private void converObjectToParameter(Object obj)
    {
        if (obj == null)
        {
            return;
        }
        
        Class supers = obj.getClass().getSuperclass();
        if (null != supers)
        {
            Field[] fields = supers.getDeclaredFields();
            if (fields.length > 0)
            {
                setMap(fields, obj);
            }
            supers = supers.getSuperclass();
            if (null != supers)
            {
                fields = supers.getDeclaredFields();
                if (fields.length > 0)
                {
                    setMap(fields, obj);
                }
            }
        }
        
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields.length > 0)
        {
            setMap(fields, obj);
        }
    }
    
    private void setMap(Field[] fields, Object obj)
    {
        for (Field field : fields)
        {
            try
            {
                field.setAccessible(true);
                this.parameter.put(field.getName(), field.get(obj));
            }
            catch (ExceptionInInitializerError e)
            {
                this.parameter.put(field.getName(), null);
            }
            catch (NullPointerException e)
            {
                this.parameter.put(field.getName(), null);
            }
            catch (IllegalArgumentException e)
            {
                this.parameter.put(field.getName(), null);
            }
            catch (IllegalAccessException e)
            {
                this.parameter.put(field.getName(), null);
            }
        }
    }
    
    public void initParameter()
    {
        converObjectToParameter(this.obj);
        if ((null != this.appendSql) && (!"".equals(this.appendSql)))
        {
            this.parameter.put("appendSql", this.appendSql);
        }
    }
    
    public void putParameter(String key, Object value)
    {
        this.parameter.put(key, value);
    }
    
    public void removeParameter(String key)
    {
        this.parameter.remove(key);
    }
}
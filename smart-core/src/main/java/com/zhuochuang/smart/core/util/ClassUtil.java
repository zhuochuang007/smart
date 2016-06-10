package com.zhuochuang.smart.core.util;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 类操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class ClassUtil
{
    private static final Logger logger = LoggerFactory.getLogger(ClassUtil.class);
    
    /** 
     * 获取类加载器
     * <功能详细描述>
     * @return 
     */
    public static ClassLoader getClassLoader()
    {
        return Thread.currentThread().getContextClassLoader();
    }
    
    /** 
     * 获取类路径 
     * <功能详细描述>
     * @return 
     */
    public static String getClassPath()
    {
        String classpath = "";
        URL resource = getClassLoader().getResource(classpath);
        if (resource != null)
        {
            classpath = resource.getPath();
        }
        return classpath;
    }
    
    /** 
     * 加载类(将自动初始化)
     * <功能详细描述>
     * @param className
     * @return 
     */
    public static Class<?> loadClass(String className)
    {
        return loadClass(className, true);
    }
    
    /** 
     * 加载类 
     * <功能详细描述>
     * @param className
     * @param isInitialized
     * @return 
     */
    public static Class<?> loadClass(String className, boolean isInitialized)
    {
        Class<?> cls;
        try
        {
            cls = Class.forName(className, isInitialized, getClassLoader());
        }
        catch (ClassNotFoundException e)
        {
            logger.error("加载类出错!", e);
            throw new RuntimeException(e);
        }
        return cls;
    }
    
    /** 
     * 是否为String类型 
     * <功能详细描述>
     * @param type
     * @return 
     */
    public static boolean isString(Class<?> type)
    {
        return type.equals(String.class);
    }
    
    /** 
     * 是否为int或Integer类型 
     * <功能详细描述>
     * @param type
     * @return 
     */
    public static boolean isInt(Class<?> type)
    {
        return type.equals(int.class) || type.equals(Integer.class);
    }
    
    /** 
     * 是否为long或Long类型 
     * <功能详细描述>
     * @param type
     * @return 
     */
    public static boolean isLong(Class<?> type)
    {
        return type.equals(long.class) || type.equals(Long.class);
    }
    
    /** 
     * 是否为double或Double类型 
     * <功能详细描述>
     * @param type
     * @return 
     */
    public static boolean isDouble(Class<?> type)
    {
        return type.equals(double.class) || type.equals(Double.class);
    }
}

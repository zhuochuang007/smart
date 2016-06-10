package com.zhuochuang.smart.core.util;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

/** 
 * 集合操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class CollectionUtil
{
    /** 
     * 判断集合是否非空 
     * <功能详细描述>
     * @param collection
     * @return 
     */
    public static boolean isNotEmpty(Collection<?> collection)
    {
        return CollectionUtils.isNotEmpty(collection);
    }
    
    /** 
     * 判断集合是否为空
     * <功能详细描述>
     * @param collection
     * @return 
     */
    public static boolean isEmpty(Collection<?> collection)
    {
        return CollectionUtils.isEmpty(collection);
    }
}

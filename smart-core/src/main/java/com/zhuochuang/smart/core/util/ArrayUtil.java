package com.zhuochuang.smart.core.util;

import org.apache.commons.lang.ArrayUtils;

/** 
 * 数组操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class ArrayUtil
{
    /** 
     * 判断数据是否非空 
     * <功能详细描述>
     * @param array
     * @return 
     */
    public static boolean isNotEmpty(Object[] array)
    {
        return !ArrayUtils.isEmpty(array);
    }
    
    /** 
     * 判断数组是否为空
     * <功能详细描述>
     * @param array
     * @return 
     */
    public static boolean isEmpty(Object[] array)
    {
        return ArrayUtils.isEmpty(array);
    }
    
    /** 
     * 连接数组 
     * <功能详细描述>
     * @param array1
     * @param array2
     * @return 
     */
    public static Object[] concat(Object[] array1, Object[] array2)
    {
        return ArrayUtils.addAll(array1, array2);
    }
    
    /** 
     * 判断对象是否在数组中存在 
     * <功能详细描述>
     * @param array
     * @param obj
     * @return 
     */
    public static <T> boolean contains(T[] array, T obj)
    {
        return ArrayUtils.contains(array, obj);
    }
}

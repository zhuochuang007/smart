package com.zhuochuang.smart.core.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

/** 
 * 映射操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class MapUtil
{
    /** 
     * 判断Map是否非空 
     * <功能详细描述>
     * @param map
     * @return 
     */
    public static boolean isNotEmpty(Map<?, ?> map)
    {
        return MapUtils.isNotEmpty(map);
    }
    
    /** 
     * 判断Map是否为空 
     * <功能详细描述>
     * @param map
     * @return 
     */
    public static boolean isEmpty(Map<?, ?> map)
    {
        return MapUtils.isEmpty(map);
    }
    
    /** 
     * 转置Map 
     * <功能详细描述>
     * @param source
     * @return 
     */
    public static <K, V> Map<V, K> invert(Map<K, V> source)
    {
        Map<V, K> target = null;
        if (isNotEmpty(source))
        {
            target = new LinkedHashMap<V, K>(source.size());
            for (Map.Entry<K, V> entry : source.entrySet())
            {
                target.put(entry.getValue(), entry.getKey());
            }
        }
        return target;
    }
}

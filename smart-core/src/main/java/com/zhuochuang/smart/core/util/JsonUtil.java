package com.zhuochuang.smart.core.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * JSON操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class JsonUtil
{
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /** 
     * 将 Java对象转为JSON字符串 
     * <功能详细描述>
     * @param obj
     * @return 
     */
    public static <T> String toJSON(T obj)
    {
        String jsonStr;
        try
        {
            jsonStr = objectMapper.writeValueAsString(obj);
        }
        catch (Exception e)
        {
            logger.error("Java转Json出错！", e);
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
    
    /** 
     * 将JSON字符串转为Java对象 
     * <功能详细描述>
     * @param json
     * @param type
     * @return 
     */
    public static <T> T fromJSON(String json, Class<T> type)
    {
        T obj;
        try
        {
            obj = objectMapper.readValue(json, type);
        }
        catch (Exception e)
        {
            logger.error("Json转Java出错！", e);
            throw new RuntimeException(e);
        }
        return obj;
    }
}

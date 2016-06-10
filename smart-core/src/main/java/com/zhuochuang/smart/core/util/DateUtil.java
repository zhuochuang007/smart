package com.zhuochuang.smart.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 日期操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class DateUtil
{
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
    
    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    
    /** 
     * 格式化日期与时间 
     * <功能详细描述>
     * @param timestamp
     * @return 
     */
    public static String formatDatetime(long timestamp)
    {
        return datetimeFormat.format(new Date(timestamp));
    }
    
    /** 
     * 格式化日期 
     * <功能详细描述>
     * @param timestamp
     * @return 
     */
    public static String formatDate(long timestamp)
    {
        return dateFormat.format(new Date(timestamp));
    }
    
    /** 
     * 格式化时间 
     * <功能详细描述>
     * @param timestamp
     * @return 
     */
    public static String formatTime(long timestamp)
    {
        return timeFormat.format(new Date(timestamp));
    }
    
    /** 
     * 获取当前日期与时间 
     * <功能详细描述>
     * @return 
     */
    public static String getCurrentDatetime()
    {
        return datetimeFormat.format(new Date());
    }
    
    /** 
     * 获取当前日期 
     * <功能详细描述>
     * @return 
     */
    public static String getCurrentDate()
    {
        return dateFormat.format(new Date());
    }
    
    /** 
     * 获取当前时间 
     * <功能详细描述>
     * @return 
     */
    public static String getCurrentTime()
    {
        return timeFormat.format(new Date());
    }
    
    /** 
     * 解析日期与时间
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static Date parseDatetime(String str)
    {
        Date date = null;
        try
        {
            date = datetimeFormat.parse(str);
        }
        catch (ParseException e)
        {
            logger.error("解析日期与时间字符串出错！格式：yyyy-MM-dd HH:mm:ss", e);
        }
        return date;
    }
    
    /** 
     * 解析日期 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static Date parseDate(String str)
    {
        Date date = null;
        try
        {
            date = dateFormat.parse(str);
        }
        catch (ParseException e)
        {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd", e);
        }
        return date;
    }
    
    /** 
     * 解析时间 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static Date parseTime(String str)
    {
        Date date = null;
        try
        {
            date = timeFormat.parse(str);
        }
        catch (ParseException e)
        {
            logger.error("解析时间字符串出错！格式：HH:mm:ss", e);
        }
        return date;
    }
}

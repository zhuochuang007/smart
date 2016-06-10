package com.zhuochuang.smart.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/** 
 * 字符串操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class StringUtil
{
    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char)29);
    
    /** 
     * 判断字符串是否为空 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static boolean isEmpty(String str)
    {
        return StringUtils.isEmpty(str);
    }
    
    /** 
     * 判断字符串是否非空 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static boolean isNotEmpty(String str)
    {
        return StringUtils.isNotEmpty(str);
    }
    
    /** 
     * 若字符串为空,则取默认值
     * <功能详细描述>
     * @param str
     * @param defaultValue
     * @return 
     */
    public static String defaultIfEmpty(String str, String defaultValue)
    {
        return StringUtils.defaultIfEmpty(str, defaultValue);
    }
    
    /** 
     * 替换固定格式的字符串（支持正则表达式） 
     * <功能详细描述>
     * @param str
     * @param regex
     * @param replacement
     * @return 
     */
    public static String replaceAll(String str, String regex, String replacement)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find())
        {
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        return sb.toString();
    }
    
    /** 
     * 是否为数字(整数或小数)
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static boolean isNumber(String str)
    {
        return NumberUtils.isNumber(str);
    }
    
    /** 
     * 是否为十进制数(整数)
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static boolean isDigits(String str)
    {
        return NumberUtils.isDigits(str);
    }
    
    /** 
     * 分割固定格式的字符串 
     * <功能详细描述>
     * @param str
     * @param separator
     * @return 
     */
    public static String[] splitString(String str, String separator)
    {
        return StringUtils.splitByWholeSeparator(str, separator);
    }
    
    /** 
     * 将字符串首字母大写 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String firstToUpper(String str)
    {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
    
    /** 
     * 将字符串首字母小写 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String firstToLower(String str)
    {
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }
}

package com.zhuochuang.smart.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuochuang.smart.core.constant.SystemConstant;

/** 
 * 编码与解码操作工具类
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年4月10日] 
 */
public class CodecUtil
{
    private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);
    
    /** 
     * 将URL编码 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String encodeURL(String str)
    {
        String target;
        try
        {
            target = URLEncoder.encode(str, SystemConstant.UTF_8);
        }
        catch (Exception e)
        {
            logger.error("URL编码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /** 
     * 将URL解码 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String decodeURL(String str)
    {
        String target;
        try
        {
            target = URLDecoder.decode(str, SystemConstant.UTF_8);
        }
        catch (Exception e)
        {
            logger.error("URL解码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /** 
     * 将字符串base64编码 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String encodeBASE64(String str)
    {
        String target;
        try
        {
            target = Base64.encodeBase64URLSafeString(str.getBytes(SystemConstant.UTF_8));
        }
        catch (UnsupportedEncodingException e)
        {
            logger.error("BASE64编码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /** 
     * 将字符串base64解码 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String decodeBASE64(String str)
    {
        String target;
        try
        {
            target = new String(Base64.decodeBase64(str), SystemConstant.UTF_8);
        }
        catch (UnsupportedEncodingException e)
        {
            logger.error("BASE64解码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }
    
    /** 
     * 将字符串MD5加密 
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String encryptMD5(String str)
    {
        return DigestUtils.md5Hex(str);
    }
    
    /** 
     * 将字符串SHA加密
     * <功能详细描述>
     * @param str
     * @return 
     */
    public static String encryptSHA(String str)
    {
        return DigestUtils.sha1Hex(str);
    }
    
    /** 
     * 创建随机数 
     * <功能详细描述>
     * @param count
     * @return 
     */
    public static String createRandom(int count)
    {
        return RandomStringUtils.randomNumeric(count);
    }
    
    /** 
     * 获取32位UUID 
     * <功能详细描述>
     * @return 
     */
    public static String createUUID()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

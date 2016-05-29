package com.zhuochuang.smart.fileupload.exception;

/** 
 * 不支持的文件上传类型异常
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年5月29日] 
 */
public class NoSupportExtensionException extends RuntimeException
{
    private static final long serialVersionUID = -1311794678097379369L;
    
    public NoSupportExtensionException(String message)
    {
        super(message);
    }
}

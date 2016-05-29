package com.zhuochuang.smart.fileupload.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 获取文件上传进度
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年5月29日] 
 */
public class GetFileProcessServlet extends HttpServlet
{
    private static final long serialVersionUID = 3955686786145769183L;
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("GetFileProcessServlet#doGet start");
        String fileUploadPercent = (String)request.getSession().getAttribute("fileUploadProcess");
        Writer writer = null;
        try
        {
            writer = response.getWriter();
            logger.info("percent:" + fileUploadPercent);
            IOUtils.write(fileUploadPercent == null ? "0%" : fileUploadPercent, writer);
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        finally
        {
            IOUtils.closeQuietly(writer);
        }
        logger.info("GetFileProcessServlet#doGet end");
    }
    
}

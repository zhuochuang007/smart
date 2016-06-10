package com.zhuochuang.smart.fileupload.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhuochuang.smart.core.util.StringUtil;
import com.zhuochuang.smart.entity.file.FileVO;
import com.zhuochuang.smart.fileupload.service.IFileUploadService;

/** 
 * 下载文件
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年6月9日] 
 */
@Named("downloadServlet")
public class DownloadServlet extends HttpServlet
{
    private static final long serialVersionUID = -4038891357222176622L;
    
    private Logger logger = LoggerFactory.getLogger(DownloadServlet.class);
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        this.doPost(req, resp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        //下载类型
        String fileType = req.getParameter("fileType");
        //文件ID
        String fileId = req.getParameter("fileId");
        //文件ID
        String fileBatchId = req.getParameter("fileBatchId");
        //文件类型为空直接返回
        if (StringUtil.isEmpty(fileType))
        {
            return;
        }
        //文件id和批次号为空直接返回
        if (StringUtil.isEmpty(fileBatchId) && StringUtil.isEmpty(fileId))
        {
            return;
        }
        FileVO fileVO = new FileVO();
        fileVO.setFileId(fileId);
        fileVO.setFileBatchId(fileBatchId);
        fileVO.setFileType(fileType);
        WebApplicationContext applicationContext =
            WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IFileUploadService fileUploadService = (IFileUploadService)applicationContext.getBean("fileUploadService");
        ZipOutputStream zos = null;
        FileInputStream fis = null;
        try
        {
            List<FileVO> fileList = fileUploadService.findFileList(fileVO);
            if (CollectionUtils.isNotEmpty(fileList))
            {
                zos = new ZipOutputStream(resp.getOutputStream());
                //ZIP文件名称
                String zipFileName = fileList.get(0).getFileName();
                resp.setContentType("application/x-msdownload");
                resp.setHeader("Content-Disposition",
                    "attachment;filename=" + new String((zipFileName + ".zip").getBytes("GBK"), "ISO8859-1"));
                //服务器路径
                String path = getServletContext().getRealPath("/");
                //循环文件列表
                for (FileVO fileInfo : fileList)
                {
                    File file = new File(path + fileInfo.getFilePath() + "\\" + fileInfo.getFileTempName() + "."
                        + fileInfo.getFileSuffix());
                    zos.putNextEntry(new ZipEntry(fileInfo.getFileName() + "." + fileInfo.getFileSuffix()));
                    fis = new FileInputStream(file);
                    byte b[] = new byte[1024];
                    int n = 0;
                    while ((n = fis.read(b)) != -1)
                    {
                        zos.write(b, 0, n);
                    }
                }
            }
        }
        catch (Exception e)
        {
            logger.error("附件下载失败", e);
        }
        finally
        {
            if (zos != null)
            {
                zos.flush();
                zos.close();
            }
            if (fis != null)
            {
                fis.close();
            }
        }
    }
}

package com.zhuochuang.smart.fileupload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zhuochuang.smart.entity.file.FileVO;
import com.zhuochuang.smart.fileupload.service.IFileUploadService;
import com.zhuochuang.smart.fileupload.service.impl.FileUploadService;

/** 
 * 附件上传
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年6月9日] 
 */
@Named("uploadServlet")
@SuppressWarnings("unused")
public class UploadServlet extends HttpServlet
{
    
    private static final long serialVersionUID = -2022500537302676096L;
    
    private Logger logger = LoggerFactory.getLogger(UploadServlet.class);
    
    //正式文件存放目录
    private static final String FILE_PATH = "dm\\file";
    
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        this.doPost(req, resp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        try
        {
            //判断是否为文件上传
            boolean isMultipart = ServletFileUpload.isMultipartContent(req);
            if (isMultipart)
            {
                //获取文件上传类型
                String fileType = req.getParameter("fileType");
                //创建文件处理工厂
                DiskFileItemFactory factory = new DiskFileItemFactory();
                //获取servlet上下文
                ServletContext servletContext = this.getServletConfig().getServletContext();
                //获取服务器根目录
                String rootPath = servletContext.getRealPath("/");
                //正式文件目录
                String filePath = rootPath + FILE_PATH;
                File file = new File(filePath);
                if (!file.exists())
                {
                    boolean fileFlag = file.mkdirs();
                    if (!fileFlag)
                    {
                        logger.info("创建正式文件目录失败,path=" + filePath);
                        return;
                    }
                }
                //设置文件清除追踪器，文件上传过程中产生的临时文件会在文件上传完成后删除  
                FileCleaningTracker fileCleaningTracker =
                    FileCleanerCleanup.getFileCleaningTracker(this.getServletContext());
                //创建文件上传处理对象
                ServletFileUpload upload = new ServletFileUpload(factory);
                //解析文件上传请求
                List<FileItem> items = upload.parseRequest(req);
                //文件上传不为空
                if (!CollectionUtils.isEmpty(items))
                {
                    //文件存放批次号
                    String fileBatchId = UUID.randomUUID().toString().replace("-", "");
                    //文件信息集合
                    List<FileVO> fileList = new ArrayList<FileVO>();
                    for (FileItem fileItem : items)
                    {
                        //文件上传
                        if (!fileItem.isFormField())
                        {
                            String fieldName = fileItem.getFieldName();
                            //文件名称(包含后缀)
                            String name = fileItem.getName();
                            //文件后缀
                            String fileSuffix = FilenameUtils.getExtension(name);
                            //文件名称(不包含后缀)
                            String fileName = FilenameUtils.getName(name).replace("." + fileSuffix, "");
                            //校验文件类型是否为允许上传类型#FIXME
                            //文件大小
                            long fileSize = fileItem.getSize();
                            //校验上传文件大小是否符合文件上传限制#FIXME
                            //文件类型
                            String contentType = fileItem.getContentType();
                            //服务器文件名称使用UUID生成避免重名
                            String fileTempName = UUID.randomUUID().toString().replace("-", "") + "." + fileSuffix;
                            //保存文件到服务器
                            FileUtils.copyInputStreamToFile(fileItem.getInputStream(), new File(file, fileTempName));
                            //封装文件信息
                            FileVO fileVO = new FileVO();
                            fileVO.setFileName(fileName);
                            fileVO.setFileType(fileType);
                            fileVO.setFilePath(FILE_PATH);
                            fileVO.setFileSuffix(fileSuffix);
                            fileVO.setFileBatchId(fileBatchId);
                            fileVO.setFileTempName(fileTempName.replace("." + fileSuffix, ""));
                            fileList.add(fileVO);
                        }
                    }
                    //文件上传完成后保存文件信息
                    WebApplicationContext applicationContext =
                        WebApplicationContextUtils.getWebApplicationContext(getServletContext());
                    IFileUploadService fileUploadService =
                        (IFileUploadService)applicationContext.getBean("fileUploadService");
                    fileUploadService.createFile(fileList);
                }
            }
        }
        catch (FileUploadException e)
        {
            logger.error("上传文件错误" + e);
        }
        catch (Exception e)
        {
            logger.error("保存上传文件信息错误" + e);
        }
        
    }
}

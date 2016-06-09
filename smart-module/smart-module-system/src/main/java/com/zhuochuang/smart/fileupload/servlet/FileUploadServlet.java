package com.zhuochuang.smart.fileupload.servlet;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhuochuang.smart.entity.file.FileVO;
import com.zhuochuang.smart.fileupload.exception.NoSupportExtensionException;
import com.zhuochuang.smart.fileupload.listener.FileProcessListener;
import com.zhuochuang.smart.fileupload.service.IFileUploadService;

/** 
 * 附件上传
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年5月29日] 
 */
public class FileUploadServlet extends HttpServlet
{
    private static final long serialVersionUID = 2456520394489039629L;
    
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
    
    @Inject
    private IFileUploadService fileUploadService;
    
    /** 上传目录名*/
    private static final String uploadFolderName = "uploadFiles";
    
    /** 上传临时文件存储目录*/
    private static final String tempFolderName = "tempFiles";
    
    /** 上传文件最大为30M*/
    private static final Long fileMaxSize = 30000000L;
    
    /** 允许上传的扩展名*/
    private static final String[] extensionPermit = {"txt", "xls", "zip"};
    
    /** 统一的编码格式*/
    private static final String encode = "UTF-8";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("UploadFileServlet#doPost() start");
        try
        {
            //获取文件上传类型
            String fileType = request.getParameter("fileType");
            //当前服务器根目录
            String curProjectPath = this.getServletContext().getRealPath("/");
            //文件存放相对路径
            String filePath = "/" + uploadFolderName;
            //文件存放目录
            String saveDirectoryPath = curProjectPath + filePath;
            //临时文件存放目录
            String tempDirectoryPath = curProjectPath + "/" + tempFolderName;
            File saveDirectory = new File(saveDirectoryPath);
            File tempDirectory = new File(tempDirectoryPath);
            logger.debug("Project real path [" + saveDirectory.getAbsolutePath() + "]");
            //上传时产生的临时文件的默认保存目录  
            logger.debug("Temp files default save path [" + System.getProperty("java.io.tmpdir") + "]");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //DiskFileItemFactory中DEFAULT_SIZE_THRESHOLD=10240表示如果上传文件大于10K则会产生上传临时文件  
            //上传临时文件的默认目录为java.io.tmpdir中保存的路径，根据操作系统的不同会有区别  
            if (!tempDirectory.exists())
            {
                tempDirectory.mkdir();
            }
            //重新设置临时文件保存目录  
            factory.setRepository(tempDirectory);
            //设置文件清除追踪器，文件上传过程中产生的临时文件会在文件上传完成后删除  
            FileCleaningTracker fileCleaningTracker =
                FileCleanerCleanup.getFileCleaningTracker(this.getServletContext());
            factory.setFileCleaningTracker(fileCleaningTracker);
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置文件上传进度监听器  
            FileProcessListener processListener = new FileProcessListener(request.getSession());
            upload.setProgressListener(processListener);
            // 设置文件上传的大小限制(取数据字典配置)#FIXME  
            upload.setFileSizeMax(fileMaxSize);
            // 设置文件上传的头编码，如果需要正确接收中文文件路径或者文件名  
            // 这里需要设置对应的字符编码，为了通用这里设置为UTF-8  
            upload.setHeaderEncoding(encode);
            //存放文件信息集合
            List<FileVO> fileList = new ArrayList<FileVO>();
            //文件存放批次号
            String fileBatchId = UUID.randomUUID().toString().replace("-", "");
            //解析请求数据包  
            List<FileItem> fileItems = upload.parseRequest(request);
            //遍历解析完成后的Form数据和上传文件数据  
            for (Iterator<FileItem> iterator = fileItems.iterator(); iterator.hasNext();)
            {
                FileItem fileItem = iterator.next();
                String fieldName = fileItem.getFieldName();
                String name = fileItem.getName();
                //如果为上传文件数据  
                if (!fileItem.isFormField())
                {
                    logger.debug("fieldName[" + fieldName + "] fileName[" + name + "] ");
                    if (fileItem.getSize() > 0)
                    {
                        String fileSuffix = FilenameUtils.getExtension(name);
                        //校验文件后缀是否为允许上传类型(取数据字典配置)#FIXME
                        if (!ArrayUtils.contains(extensionPermit, fileSuffix))
                        {
                            throw new NoSupportExtensionException("No Support extension.");
                        }
                        //文件名称
                        String fileName = FilenameUtils.getName(name);
                        //文件存放服务器名称，使用UUID避免重名
                        String fileTempName = UUID.randomUUID().toString().replace("-", "");
                        FileUtils.copyInputStreamToFile(fileItem.getInputStream(),
                            new File(saveDirectory, fileTempName));
                        //封装文件实体信息
                        FileVO fileVO = new FileVO();
                        fileVO.setFileName(fileName);
                        fileVO.setFileType(fileType);
                        fileVO.setFilePath(filePath);
                        fileVO.setFileSuffix(fileSuffix);
                        fileVO.setFileBatchId(fileBatchId);
                        fileList.add(fileVO);
                    }
                }
                else
                { //Form表单数据  
                    String value = fileItem.getString(encode);
                    logger.debug("fieldName[" + value + "] fieldValue[" + fieldName + "]");
                }
            }
            //保存文件信息#FIXME
            fileUploadService.createFile(fileList);
            
            responseMessage(response, State.OK);
        }
        catch (FileSizeLimitExceededException e)
        {
            logger.error(e.getMessage(), e);
            responseMessage(response, State.OVER_FILE_LIMIT);
        }
        catch (NoSupportExtensionException e)
        {
            logger.error(e.getMessage(), e);
            responseMessage(response, State.NO_SUPPORT_EXTENSION);
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            responseMessage(response, State.ERROR);
        }
        finally
        {
            //清除上传进度信息  
            request.getSession().removeAttribute("fileUploadProcess");
        }
        logger.info("UploadFileServlet#doPost() end");
    }
    
    public enum State
    {
        OK(200, "上传成功"), ERROR(500, "上传失败"), OVER_FILE_LIMIT(501, "超过上传大小限制"), NO_SUPPORT_EXTENSION(502, "不支持的扩展名");
        
        private int code;
        
        private String message;
        
        private State(int code, String message)
        {
            this.code = code;
            this.message = message;
        }
        
        public int getCode()
        {
            return code;
        }
        
        public String getMessage()
        {
            return message;
        }
        
    }
    
    /** 
     * 返回结果函数 
     * @param response 
     * @param state 
     */
    private void responseMessage(HttpServletResponse response, State state)
    {
        response.setCharacterEncoding(encode);
        response.setContentType("text/html; charset=" + encode);
        Writer writer = null;
        try
        {
            writer = response.getWriter();
            writer.write("<script>");
            writer.write("window.parent.fileUploadCallBack({\"code\":" + state.getCode() + ",\"message\":\""
                + state.getMessage() + "\"});");
            writer.write("</script>");
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
    }
}

package com.zhuochuang.smart.entity.file;

import com.zhuochuang.smart.entity.base.BaseEntity;

/** 
 * 文件上传实体
 * <功能详细描述> 
 * 
 * @author  ouxin 
 * @version  [版本号, 2016年5月30日] 
 */
public class FileVO extends BaseEntity
{
    
    private static final long serialVersionUID = 8588353057195115468L;
    
    /**
     * 文件名称
     */
    private String fileName;
    
    /**
     * 文件ID
     */
    private String fileId;
    
    /**
     * 文件服务器相对路径
     */
    private String filePath;
    
    /**
     * 文件批次号
     */
    private String fileBatchId;
    
    /**
     * 文件类型
     */
    private String fileType;
    
    /**
     * 文件后缀名
     */
    private String fileSuffix;
    
    /**
     * 上传时间
     */
    private String uploadDate;
    
    /**
     * 服务器文件存放名称
     */
    private String fileTempName;
    
    /**
     * 文件状态1：正常0：删除
     */
    private String fileStatus;
    
    public String getFileName()
    {
        return fileName;
    }
    
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
    
    public String getFileId()
    {
        return fileId;
    }
    
    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }
    
    public String getFilePath()
    {
        return filePath;
    }
    
    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }
    
    public String getFileBatchId()
    {
        return fileBatchId;
    }
    
    public void setFileBatchId(String fileBatchId)
    {
        this.fileBatchId = fileBatchId;
    }
    
    public String getFileType()
    {
        return fileType;
    }
    
    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }
    
    public String getFileSuffix()
    {
        return fileSuffix;
    }
    
    public void setFileSuffix(String fileSuffix)
    {
        this.fileSuffix = fileSuffix;
    }
    
    public String getUploadDate()
    {
        return uploadDate;
    }
    
    public void setUploadDate(String uploadDate)
    {
        this.uploadDate = uploadDate;
    }

    public String getFileTempName()
    {
        return fileTempName;
    }

    public void setFileTempName(String fileTempName)
    {
        this.fileTempName = fileTempName;
    }

    public String getFileStatus()
    {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus)
    {
        this.fileStatus = fileStatus;
    }
}

package com.zhuochuang.smart.fileupload.service;

import java.util.List;

import com.zhuochuang.smart.entity.file.FileVO;

public interface IFileUploadService
{
    /** 
     * 保存文件上传信息 
     * <功能详细描述>
     * @param fileVO
     * @throws Exception 
     */
    public void createFile(List<FileVO> fileList)
        throws Exception;
}

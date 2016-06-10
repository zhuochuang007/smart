package com.zhuochuang.smart.fileupload.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.zhuochuang.smart.entity.file.FileVO;
import com.zhuochuang.smart.fileupload.dao.IFileUploadDao;
import com.zhuochuang.smart.fileupload.service.IFileUploadService;

@Named("fileUploadService")
public class FileUploadService implements IFileUploadService
{
    @Inject
    private IFileUploadDao fileUploadDao;
    
    @Override
    public void createFile(List<FileVO> fileList)
        throws Exception
    {
        fileUploadDao.createFile(fileList);
    }
    
    @Override
    public FileVO findFileById(FileVO fileVO)
        throws Exception
    {
        return fileUploadDao.findFileById(fileVO);
    }
    
    @Override
    public List<FileVO> findFileList(FileVO fileVO)
        throws Exception
    {
        return fileUploadDao.findFileList(fileVO);
    }
    
}

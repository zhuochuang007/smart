package com.zhuochuang.smart.fileupload.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhuochuang.smart.entity.file.FileVO;

public interface IFileUploadDao
{
    public void createFile(@Param("fileList") List<FileVO> fileList);
    
    public FileVO findFileById(@Param("fileVO") FileVO fileVO);
    
    public List<FileVO> findFileList(@Param("fileVO") FileVO fileVO);
}

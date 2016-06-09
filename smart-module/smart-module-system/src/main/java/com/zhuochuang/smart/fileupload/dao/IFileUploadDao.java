package com.zhuochuang.smart.fileupload.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhuochuang.smart.entity.file.FileVO;

public interface IFileUploadDao
{
    public int createFile(@Param("fileList") List<FileVO> fileList);
}

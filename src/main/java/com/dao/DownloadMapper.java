package com.dao;

import com.bean.DownloadRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DownloadMapper {

    int insert(DownloadRecord downloadRecord);

    int update(String id, String downloadDate);

}

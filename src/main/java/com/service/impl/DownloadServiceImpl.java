package com.service.impl;

import com.bean.DownloadRecord;
import com.dao.DownloadMapper;
import com.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private DownloadMapper downloadMapper;

    @Override
    public void insert(DownloadRecord downloadRecord) {
        downloadMapper.insert(downloadRecord);
    }

    @Override
    public void update(String id, String downloadDate) {
        downloadMapper.update(id, downloadDate);
    }
}

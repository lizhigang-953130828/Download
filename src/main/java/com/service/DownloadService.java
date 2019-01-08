package com.service;

import com.bean.DownloadRecord;

public interface DownloadService {

    void insert(DownloadRecord downloadRecord);

    void update(String id, String downloadDate);
}

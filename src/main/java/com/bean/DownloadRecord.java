package com.bean;


import javax.servlet.http.HttpServletRequest;
import com.utils.*;

/**
 * 下载请求记录实体
 * @author lizhigang
 */
public class DownloadRecord {
    private int id;
    private String packetNo;
    private String appNo;
    private String ip;
    private String downloadNum;
    private String downloadDate;
    private String date;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacketNo() {
        return packetNo;
    }

    public void setPacketNo(String packetNo) {
        this.packetNo = packetNo;
    }

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDownloadNum() {
        return downloadNum;
    }

    public void setDownloadNum(String downloadNum) {
        this.downloadNum = downloadNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
    }

    public static DownloadRecord getDownloadRecord(HttpServletRequest request){
        DownloadRecord downloadRecord = new DownloadRecord();
        downloadRecord.setAppNo(request.getParameter("appNo"));
        downloadRecord.setPacketNo(request.getParameter("packetNo"));
        downloadRecord.setIp(RequestUtils.getRequestIp(request));
        downloadRecord.setDownloadNum("1");
        downloadRecord.setDate(DateUtil.getYearDay());
        downloadRecord.setTime(DateUtil.getTime());
        return downloadRecord;
    }
}

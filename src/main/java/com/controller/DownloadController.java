package com.controller;

import com.bean.DownloadRecord;
import com.service.DownloadService;
import com.utils.DateUtil;
import com.utils.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("download")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;

    @RequestMapping("apk.action")
    public void download(HttpServletResponse response, HttpServletRequest request){
        try {
            if (ParamUtil.isEmpty(request.getParameter("appNo"),request.getParameter("packetNo"))) {
                Long beginDate = DateUtil.getMillisecond();
                DownloadRecord downloadRecord = DownloadRecord.getDownloadRecord(request);
                downloadService.insert(downloadRecord);
                // 指定下载的文件的路径
                File file = new File("./apk/comparison_card-release.apk");//ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/apk/comparison_card-release.apk");
                // 取得文件名
                String filename = file.getName();
                // 取得文件的后缀名
                String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
                // 以流的形式下载文件
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
                response.reset();
                // 设置response的Header
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                response.setContentType("application/octet-stream");
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
                Long lastDate = DateUtil.getMillisecond();
                String downloadDate = String.valueOf(lastDate-beginDate);
                downloadService.update(String.valueOf(downloadRecord.getId()), downloadDate);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

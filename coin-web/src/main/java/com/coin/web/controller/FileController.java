package com.coin.web.controller;

import com.coin.req.FileReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.DateUtil;
import com.coin.web.annotation.OfficeSecure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${upload.url}")
    private String picUrl;

    @RequestMapping("/upload")
    @OfficeSecure
    public MyResp upload(FileReq req, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        try {
            String fileName = DateUtil.getTodayStr() + file.getOriginalFilename();
            File newFile = new File(picUrl +'/'+ fileName);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
        } catch (Exception e) {
            logger.error("file-upload-error", e);
            return new MyResp(CodeCons.ERROR, "上传失败");
        }
        return new MyResp(CodeCons.SUCCESS, "上传成功");
    }

    @RequestMapping("/download")
    @OfficeSecure
    public MyResp download(@RequestBody FileReq req, HttpServletResponse response) {
        try {
            File file = new File(picUrl +"\\" + req.getFileName());
            String filename = file.getName();
            filename = new String(filename.replaceAll(" ", "").getBytes("UTF-8"), "ISO8859-1");
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException e) {
            logger.error("file-download-error", e);
            return new MyResp(CodeCons.ERROR, "下载失败");
        }
        return new MyResp(CodeCons.SUCCESS, "下载成功");
    }

}

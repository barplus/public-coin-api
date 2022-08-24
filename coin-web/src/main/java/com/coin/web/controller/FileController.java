package com.coin.web.controller;

import com.coin.req.FileReq;
import com.coin.rsp.template.CustomerTemplate;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.constant.CodeCons;
import com.coin.service.util.DateUtil;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${upload.url}")
    private String picUrl;

    @RequestMapping("/upload")
    @OfficeSecure
    public MyResp upload(FileReq req, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String fileName = "";
        try {
            fileName = DateUtil.getTodayStr("yyyyMMddHHmmssSSS") + file.getOriginalFilename();
            File newFile = new File(picUrl +'/'+ fileName);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            file.transferTo(newFile);
        } catch (Exception e) {
            logger.error("file-upload-error", e);
            return new MyResp(CodeCons.ERROR, "上传失败");
        }
        return new MyResp(CodeCons.SUCCESS, "上传成功", fileName);
    }

    @RequestMapping("/downloadNoLogin")
    public void downloadNoLogin(FileReq req, HttpServletResponse response) {
        this.download(req, response);
    }

    @RequestMapping("/download")
    @OfficeSecure
    public void download(FileReq req, HttpServletResponse response) {
        try {
            MyResp valid = ParamUtil.NotBlankValid(req.getFileName(), "文件名");
            if(valid != null){
                return;
            }
            File file = new File(picUrl + req.getFileName());
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
        } catch (IOException ee) {
            logger.error("file-download-e1", ee);
        } catch (Exception e) {
            logger.error("file-download-error", e);
        }
    }

    @RequestMapping(value = "downloadExcel")
    @OfficeSecure
    public void downloadExcel(FileReq req, HttpServletResponse response) {
        try{
            if("customer.xlsx".equals(req.getFileName())){
                FileUtil.exportExcel(new ArrayList<>(), CustomerTemplate.class, req.getFileName(), response);
            }
        }catch(Exception e){
            logger.error("file-downloadExcel-error", e);
        }
    }

}
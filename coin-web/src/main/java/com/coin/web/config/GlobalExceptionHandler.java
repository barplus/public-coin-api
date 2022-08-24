package com.coin.web.config;

import com.coin.service.BizEntity.MyResp;
import com.coin.service.constant.CodeCons;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MultipartException.class)
    @ResponseBody
    public MyResp handleBusinessException(MaxUploadSizeExceededException ex) {
        if (ex.getCause().getCause() instanceof SizeLimitExceededException) {
            logger.error("请求数据大小超过20M", ex);
            return new MyResp(CodeCons.ERROR, "请求数据大小不能超过20M");
        }
        return null;
    }

}

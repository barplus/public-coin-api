package com.coin.web.interceptor;

import com.coin.service.constant.CodeCons;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 全局拦截器
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
        int i = 0;
        if(i == 1){
            setJsonMessage(response, CodeCons.ERROR, "请求失败，异常");
            return false;
        }
        return true;
    }

    private void setJsonMessage(HttpServletResponse response, String code, String msg) throws Exception{
        String jsonStr = "{\"head\":{\"code\":\""+code+"\",\"message\":\""+msg+"\"},\"body\":null}";
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(jsonStr);
        writer.close();
        response.flushBuffer();
    }

}

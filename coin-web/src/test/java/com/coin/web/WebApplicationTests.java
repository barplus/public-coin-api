package com.coin.web;

import com.coin.service.util.OkHttpUtil;
import com.coin.web.controller.SysUserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;

@SpringBootTest
class WebApplicationTests {

    @Resource
    private SysUserController controller;
    @Resource
    private OkHttpUtil okHttpUtil;

    @Test
    void test() throws InterruptedException {
        //-1001585934370
        String url = "https://api.telegram.org/bot5467785070:AAHPzNQMZAusg9Az7wY2L-xs5sblT9SjvT4/sendMessage?chat_id=5517979780&text=0000000";
        for(int i=0; ;i++){
            Thread.sleep(5000l);
            okHttpUtil.getMap(url, new HashMap<>());
        }
//        JSONObject json = new JSONObject();
//        json.put("loginName", "admin");
//        json.put("loginPass", "217990acc970115f975cfaec90d3c12c");
//        String result = okHttpUtil.postJSON("http://localhost:8088/customer/login", json);
//        System.out.println(result);
//        SysUserReq req = new SysUserReq();
//        req.setLoginName("admin");
//        req.setLoginPass("e10adc3949ba59abbe56e057f20f883e");
//        MyResp resp = controller.login(req);
//        System.out.println(BizUtil.objToJson(resp).toJSONString());
    }

}

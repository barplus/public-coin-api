package com.coin.web;

import com.coin.entity.SysUser;
import com.coin.req.office.SysUserReq;
import com.coin.service.BizEntity.MyResp;
import com.coin.utils.BizUtil;
import com.coin.web.controller.office.SysUserController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class WebApplicationTests {

    @Resource
    private SysUserController controller;

    @Test
    void test() {
        SysUserReq req = new SysUserReq();
        req.setLoginName("admin");
        req.setLoginPass("e10adc3949ba59abbe56e057f20f883e");
        MyResp resp = controller.login(req);
        System.out.println(BizUtil.objToJson(resp).toJSONString());
    }

}

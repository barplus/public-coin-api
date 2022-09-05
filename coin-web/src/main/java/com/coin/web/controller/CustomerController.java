package com.coin.web.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.coin.entity.TCustomer;
import com.coin.req.CommonReq;
import com.coin.req.CustomerReq;
import com.coin.rsp.CustomerRsp;
import com.coin.rsp.PrizeRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.CustPrizeService;
import com.coin.service.CustomerService;
import com.coin.service.constant.BizCons;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.*;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.annotation.OfficeSecure;
import com.coin.web.utils.FileUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;
    @Resource
    private CustPrizeService custPrizeService;
    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/login")
    @CommonSecure(needLogin = false)
    public MyResp login(@RequestBody CustomerReq req){
        logger.info("customer-login-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getLoginName(), "登录名", req.getLoginPass(), "登录密码");
            if(valid != null){
                return valid;
            }
            if(req.getLoginName().length() < 4 || req.getLoginName().length() > 12){
                return new MyResp(CodeCons.ERROR, "登录名格式错误");
            }
            TCustomer customer = customerService.getInfoByLoginName(req.getLoginName());
            if(customer == null){
                customerService.createCustomer(req.getLoginName(), MD5Util.MD5(req.getLoginPass()), req.getSource());
                customer = customerService.getInfoByLoginName(req.getLoginName());
            }
            customerService.updateIsLogin(req.getLoginName());
            if(StringUtils.isBlank(customer.getLoginPass())){
                TCustomer updateCustomer = BizUtil.getUpdateInfo(new TCustomer(), customer.getId(), req.getLoginName(), new Date());
                updateCustomer.setLoginPass(MD5Util.MD5(req.getLoginPass()));
                customerService.updateLoginPass(updateCustomer, 1, req.getLoginName());
            } else if(!MD5Util.MD5(req.getLoginPass()).equals(customer.getLoginPass())){
                return new MyResp(CodeCons.ERROR, "登录失败，请输入正确专用码");
            }
            String tokenKey = BizCons.SYS_API + customer.getLoginName() + ":token";
            String oldToken = redisUtil.get(tokenKey);
            if(StringUtils.isNotBlank(oldToken)){
                redisUtil.remove(oldToken);
                redisUtil.remove(tokenKey);
            }
            String token = MD5Util.MD5(customer.getLoginName() + System.currentTimeMillis() + BizUtil.getStringRandom(5, 1));
            redisUtil.set(token, customer.getLoginName(), 1800);
            redisUtil.set(tokenKey, token, 1800);
            CustomerRsp rsp = customerService.getByLoginName(customer.getLoginName(), true);
            return new MyResp(CodeCons.SUCCESS, token, rsp);
        }catch(Exception e){
            logger.error("customer-login-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/logout")
    @CommonSecure
    public MyResp logout(@RequestBody CustomerReq req){
        logger.info("customer-logout-req={}", req);
        try{
            TCustomer customer = customerService.getInfoByLoginName(req.getLoginName());
            String tokenKey = customer.getLoginName()+":token";
            if(redisUtil.get(tokenKey) != null){
                String oldToken = redisUtil.get(redisUtil.get(tokenKey));
                if(oldToken != null){
                    redisUtil.remove(redisUtil.get(tokenKey));
                }
                redisUtil.remove(tokenKey);
            }
            return new MyResp(CodeCons.SUCCESS, "退出成功");
        }catch(Exception e){
            logger.error("customer-logout-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getCustInfo")
    @CommonSecure(fastQuery = true)
    public MyResp getCustInfo(@RequestBody CommonReq req){
        logger.info("customer-getCustInfo-req={}", req);
        try{
            CustomerRsp customer = customerService.getByLoginName(req.getLoginName(), true);
            return new MyResp(CodeCons.SUCCESS, "", customer);
        }catch(Exception e){
            logger.error("customer-getCustInfo-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/doLottery")
    @CommonSecure
    public MyResp doLottery(@RequestBody CommonReq req){
        logger.info("customer-doLottery-req={}", req);
        try{
            PrizeRsp prizeRsp = custPrizeService.doLottery(req.getLoginName());
            logger.info("customer-doLottery-result={}, loginName={}", prizeRsp, req.getLoginName());
            if(prizeRsp == null){
                return new MyResp(CodeCons.SUCCESS, "本次抽奖未中奖，请您再接再厉", null);
            }
            return new MyResp(CodeCons.SUCCESS, "", prizeRsp);
        }catch(BizException e){
            logger.error("customer-doLottery-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-doLottery-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/doLotteryTen")
    @CommonSecure
    public MyResp doLotteryTen(@RequestBody CommonReq req){
        logger.info("customer-doLotteryTen-req={}", req);
        try{
            List<PrizeRsp> prizeRsps = custPrizeService.doLotteryTen(req.getLoginName());
            logger.info("customer-doLotteryTen-result={}, loginName={}", prizeRsps, req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "", prizeRsps);
        }catch(BizException e){
            logger.error("customer-doLotteryTen-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-doLotteryTen-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/pageList")
    @OfficeSecure(fastQuery = true)
    public MyResp pageList(@RequestBody CustomerReq req){
        logger.info("customer-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<CustomerRsp> page = customerService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(Exception e){
            logger.error("customer-pageList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @RequestMapping("/exportDatas")
    @OfficeSecure(doDownLoad = true)
    public MyResp exportDatas(CustomerReq req, HttpServletResponse response){
        logger.info("customer-exportDatas-req={}", req);
        try{
            req.setPageNum(1);
            req.setPageSize(20000);
            PageInfo<CustomerRsp> page = customerService.pageList(req);
            List<CustomerRsp> rsps = page.getList();
            FileUtil.exportExcel(rsps, CustomerRsp.class, DateUtil.getTodayStr()+"会员记录.xlsx", response);
        }catch(BizException e){
            logger.error("customer-exportDatas-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-exportDatas-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "导出失败");
    }

    @RequestMapping(value = "/importCustomerList")
    @OfficeSecure
    public MyResp importCustomerList(CustomerReq req, @RequestPart("file") MultipartFile file) {
        logger.info("custPrize-importCustomerList-req={}", req);
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        try {
            String fileName = file.getOriginalFilename();
            if(!"customer.xlsx".equals(fileName)){
                throw new BizException(CodeCons.ERROR, "请使用模板文件导入");
            }
            List<CustomerRsp> list = ExcelImportUtil.importExcel(file.getInputStream(), CustomerRsp.class, params);
            customerService.importCustomerList(list, req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "导入成功");
        } catch (BizException e) {
            logger.error("custPrize-importCustomerList-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        } catch (Exception e) {
            logger.error("custPrize-importCustomerList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "导入失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody CustomerReq req){
        logger.info("customer-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id", req.getRouletteTotalTime(), "抽奖次数");
            if(valid != null){
                return valid;
            }
            if(req.getRouletteTotalTime().intValue() != 0){
                customerService.updateTotalNum(req);
            }
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("customer-update-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-update-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/updateWallet")
    @CommonSecure
    public MyResp updateWallet(@RequestBody CustomerReq req){
        logger.info("customer-updateWallet-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getWallet(), "wallet");
            if(valid != null){
                return valid;
            }
            customerService.updateWallet(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("customer-updateWallet-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-updateWallet-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/everydaySign")
    @CommonSecure
    public MyResp everydaySign(@RequestBody CustomerReq req){
        logger.info("customer-everydaySign-req={}", req);
        try{
            customerService.everydaySign(req);
            return new MyResp(CodeCons.SUCCESS, "签到成功");
        }catch(BizException e){
            logger.error("customer-everydaySign-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-everydaySign-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "签到失败");
    }

    @PostMapping("/clearLoginPass")
    @OfficeSecure
    public MyResp clearLoginPass(@RequestBody CustomerReq req){
        logger.info("customer-clearLoginPass-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getQueryLoginName(), "queryLoginName");
            if(valid != null){
                return valid;
            }
            TCustomer oldCustomer = customerService.getInfoByLoginName(req.getQueryLoginName());
            TCustomer customer = BizUtil.getUpdateInfo(new TCustomer(), oldCustomer.getId(), req.getLoginName(), new Date());
            customerService.updateLoginPass(customer, 0, req.getLoginName());
            return new MyResp(CodeCons.SUCCESS, "操作成功");
        }catch(BizException e){
            logger.error("customer-clearLoginPass-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("customer-clearLoginPass-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}

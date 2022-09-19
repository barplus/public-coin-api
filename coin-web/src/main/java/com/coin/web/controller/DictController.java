package com.coin.web.controller;

import com.coin.entity.TDict;
import com.coin.req.ContestConfigReq;
import com.coin.req.DictReq;
import com.coin.rsp.ContestConfigRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.DictService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.CommonSecure;
import com.coin.web.annotation.OfficeSecure;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {

    private static final Logger logger = LoggerFactory.getLogger(DictController.class);

    @Resource
    private DictService dictService;

    @PostMapping("/getDicts")
    @OfficeSecure
    public MyResp pageList(@RequestBody DictReq req){
        logger.info("dict-getDicts-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getDictType(), "字典类型");
            if(valid != null){
                return valid;
            }
            List<TDict> list = dictService.getListByType(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(Exception e){
            logger.error("dict-getDicts-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getDictList")
    @CommonSecure
    public MyResp getDictList(@RequestBody DictReq req){
        logger.info("dict-getDictList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getDictType(), "字典类型");
            if(valid != null){
                return valid;
            }
            List<TDict> list = dictService.getListByType(req);
            return new MyResp(CodeCons.SUCCESS, "", list);
        }catch(Exception e){
            logger.error("dict-getDictList-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody DictReq req){
        logger.info("dict-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getDictType(), "字典类型", req.getDictCode(), "字典编码",
                    req.getDictName(), "字典名称", req.getStatus(), "状态", req.getIsDefault(), "是否默认");
            if(valid != null){
                return valid;
            }
            if(StringUtils.isBlank(req.getDictVal()) && StringUtils.isBlank(req.getDictValBig())){
                return new MyResp(CodeCons.ERROR, "字典值 不能为空");
            }
            dictService.add(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("dict-add-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("dict-add-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody DictReq req){
        logger.info("dict-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            dictService.update(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("dict-update-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("dict-update-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/del")
    @OfficeSecure
    public MyResp del(@RequestBody DictReq req){
        logger.info("dict-del-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            dictService.delete(req.getId());
            return new MyResp(CodeCons.SUCCESS, "删除成功");
        }catch(BizException e){
            logger.error("dict-del-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("dict-del-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/getContestConfig")
    @OfficeSecure
    public MyResp getContestConfig(@RequestBody DictReq req){
        logger.info("dict-getContestConfig-req={}", req);
        try{
            ContestConfigRsp config = dictService.getContestConfig();
            return new MyResp(CodeCons.SUCCESS, "", config);
        }catch(BizException e){
            logger.error("dict-getContestConfig-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("dict-getContestConfig-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/saveContestConfig")
    @OfficeSecure
    public MyResp saveContestConfig(@RequestBody ContestConfigReq req){
        logger.info("dict-saveContestConfig-req={}", req);
        try{
            dictService.saveContestConfig(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("dict-saveContestConfig-e", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("dict-saveContestConfig-error", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

}

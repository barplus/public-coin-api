package com.coin.web.controller;

import com.coin.req.SysRoleReq;
import com.coin.rsp.SysRoleRsp;
import com.coin.service.BizEntity.MyResp;
import com.coin.service.SysRoleService;
import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.ParamUtil;
import com.coin.web.annotation.OfficeSecure;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Resource
    private SysRoleService roleService;

    @PostMapping("/pageList")
    @OfficeSecure
    public MyResp pageList(@RequestBody SysRoleReq req){
        logger.info("role-pageList-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getPageNum(), "页码", req.getPageSize(), "分页大小");
            if(valid != null){
                return valid;
            }
            PageInfo<SysRoleRsp> page = roleService.pageList(req);
            return new MyResp(CodeCons.SUCCESS, "", page);
        }catch(BizException e){
            logger.error("role-pageList-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("role-pageList-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "请求失败");
    }

    @PostMapping("/add")
    @OfficeSecure
    public MyResp add(@RequestBody SysRoleReq req){
        logger.info("role-add-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getRoleCode(), "角色编码", req.getRoleName(), "角色名称");
            if(valid != null){
                return valid;
            }
            roleService.addSysRole(req);
            return new MyResp(CodeCons.SUCCESS, "添加成功");
        }catch(BizException e){
            logger.error("role-add-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("role-add-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "添加失败");
    }

    @PostMapping("/update")
    @OfficeSecure
    public MyResp update(@RequestBody SysRoleReq req){
        logger.info("role-update-req={}", req);
        try{
            MyResp valid = ParamUtil.NotBlankValid(req.getId(), "id");
            if(valid != null){
                return valid;
            }
            roleService.updateSysRole(req);
            return new MyResp(CodeCons.SUCCESS, "保存成功");
        }catch(BizException e){
            logger.error("role-update-BizException", e);
            return new MyResp(e.getCode(), e.getErrMsg());
        }catch(Exception e){
            logger.error("role-update-Exception", e);
        }
        return new MyResp(CodeCons.ERROR, "保存失败");
    }

//    @PostMapping("/saveRoleResources")
//    @OfficeSecure
//    public MyResp saveRoleResources(@RequestBody SysRoleResourceReq req){
//        logger.info("role-saveRoleResources-req={}", req);
//        try{
//            MyResp valid = ParamUtil.NotBlankValid(req.getRoleCode(), "roleCode");
//            if(valid != null){
//                return valid;
//            }
//            roleService.saveRoleResources(req);
//            return new MyResp(CodeCons.SUCCESS, "保存成功");
//        }catch(BizException e){
//            logger.error("role-saveRoleResources-BizException", e);
//            return new MyResp(e.getCode(), e.getErrMsg());
//        }catch(Exception e){
//            logger.error("role-saveRoleResources-Exception", e);
//        }
//        return new MyResp(CodeCons.ERROR, "保存失败");
//    }

}

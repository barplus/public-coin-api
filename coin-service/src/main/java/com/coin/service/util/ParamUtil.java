package com.coin.service.util;

import com.coin.service.BizEntity.MyResp;
import com.coin.service.constant.CodeCons;
import com.coin.utils.StrUtil;
import org.apache.commons.lang3.StringUtils;

public class ParamUtil {

    public static MyResp NotNullValid(Object... objs) throws Exception {
        for(int i=0; i<objs.length; i++){
            if(objs[i] == null){
                return new MyResp(CodeCons.ERROR, objs[i+1]+" 不能为空");
            }
        }
        return null;
    }

    public static MyResp NotBlankValid(Object... objs) throws Exception {
        for(int i=0; i<objs.length; i++){
            if(StringUtils.isBlank(StrUtil.getStr(objs[i]))){
                return new MyResp(CodeCons.ERROR, objs[i+1]+" 不能为空");
            }
        }
        return null;
    }

}

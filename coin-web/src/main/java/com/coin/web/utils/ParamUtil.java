package com.coin.web.utils;

import com.coin.service.constant.CodeCons;
import com.coin.service.exception.BizException;
import com.coin.service.util.StrUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParamUtil {

    /**
     * 参数XSS检查
     * @param paramObj
     */
    public static void xssCheck(Object paramObj){
        String[] sqlStrs = {"and", "exec", "execute", "insert", "select", "delete", "update", "count", "drop", "*",
                "%", "chr", "mid", "master", "truncate", "char", "declare", "sitename", "xp_cmdshell", "delete", "from",
                "column_name", "group_concat", "grant", "table_schema", "information_schema.columns", "where", "or",
                "like", "create", "use", "union", "order", "by", "#"};
        List<Field> fieldList = new ArrayList<>();
        fieldList.addAll(Arrays.asList(paramObj.getClass().getDeclaredFields()));
        if(!"com.coin.req.CommonReq".equals(paramObj.getClass().getName())){
            fieldList.addAll(Arrays.asList(paramObj.getClass().getSuperclass().getDeclaredFields()));
        }
        for(Field field : fieldList){
            field.setAccessible(true);
            try{
                String val = StrUtil.getStr(field.get(paramObj)).toLowerCase();
                for(String sqlKey:sqlStrs){
                    if(val.equals(sqlKey) || val.indexOf(sqlKey+" ") != -1 || val.indexOf(" "+sqlKey) != -1){
                        throw new BizException(CodeCons.ERROR, "请求参数值格式非法:"+val);
                    }
                }
            } catch (BizException e) {
                throw e;
            } catch (Exception e) {
                throw new BizException(CodeCons.ERROR, "请求参数值格式非法.");
            }
        }
    }

}

package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TDict implements Serializable {
    private Integer id;
    /**字典类型*/
    private String dictType;
    /**字典编码*/
    private String dictCode;
    /**字典名称*/
    private String dictName;
    /**字典值*/
    private String dictVal;
    /**字典大值*/
    private String dictValBig;
    /**上级字典编码*/
    private String parentDictCode;
    /**是否默认项*/
    private Integer isDefault;
    /**状态*/
    private Integer status;
    /**序号*/
    private Integer sortNum;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dictType=").append(dictType);
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictName=").append(dictName);
        sb.append(", dictVal=").append(dictVal);
        sb.append(", dictValBig=").append(dictValBig);
        sb.append(", parentDictCode=").append(parentDictCode);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", status=").append(status);
        sb.append(", sortNum=").append(sortNum);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
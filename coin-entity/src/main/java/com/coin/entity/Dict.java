package com.coin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;

}

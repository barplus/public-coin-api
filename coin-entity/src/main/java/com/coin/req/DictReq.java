package com.coin.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 业务用户请求对象
 */
@Data
@ToString(callSuper=true)
public class DictReq extends CommonReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**字典类型*/
    private String dictType;

}

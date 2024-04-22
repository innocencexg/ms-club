package com.xitianqujing.subject.common.entity;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求实体
 * @Author: gx
 * @CreateTime: 2024/02/19  15:56
 */
@Data
public class PageInfo implements Serializable {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }


}

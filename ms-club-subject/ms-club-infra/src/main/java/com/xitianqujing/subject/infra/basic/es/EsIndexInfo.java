package com.xitianqujing.subject.infra.basic.es;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gx
 * @CreateTime: 2024/04/18  19:14
 */
@Data
public class EsIndexInfo implements Serializable {

    /**
     * 集群名称
     */
    private String clusterName;

    /**
     * 索引名称
     */
    private String indexName;

}

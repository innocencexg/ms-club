package com.xitianqujing.subject.infra.basic.es;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: gx
 * @CreateTime: 2024/04/18  19:03
 */
@Data
public class EsClusterConfig implements Serializable {

    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;

}

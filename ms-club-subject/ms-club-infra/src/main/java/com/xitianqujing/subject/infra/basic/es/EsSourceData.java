package com.xitianqujing.subject.infra.basic.es;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;


/**
 * @Author: gx
 * @CreateTime: 2024/04/18  19:18
 */
@Data
public class EsSourceData implements Serializable {

    private String docId;

    private Map<String, Object> data;

}

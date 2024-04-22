package com.xitianqujing.oss.config;

import com.xitianqujing.oss.adapter.AliStorageAdapter;
import com.xitianqujing.oss.adapter.MinioStorageAdapter;
import com.xitianqujing.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: gx
 * @CreateTime: 2024/02/21  23:49
 */
@Configuration
@RefreshScope
public class StorageConfig {
    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}

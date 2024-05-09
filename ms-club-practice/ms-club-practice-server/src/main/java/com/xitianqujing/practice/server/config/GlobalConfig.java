package com.xitianqujing.practice.server.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xitianqujing.practice.server.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * MVC的全局处理
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/user/doLogin");
    }




    /**
     * 自定义mappingJackson2HttpMessageConverter
     * 目前实现：空值忽略，空字段可返回
     */
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        //ObjectMapper 对象是Jackson 库中用于 JSON 和 Java 对象之间进行序列化和反序列化的核心类。
        ObjectMapper objectMapper = new ObjectMapper();
        //设置在序列化过程中遇到空对象时不抛出异常。
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //设置序列化选项，指定只包含非空字段，而空字段将被忽略
        //当 Java 对象的某个属性值为 null 时，Jackson 在将其序列化为 JSON 字符串时会忽略这个属性，不包含在生成的 JSON 中。
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }

}

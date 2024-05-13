package com.xitianqujing.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.base.Preconditions;
import com.xitianqujing.subject.application.convert.CommunicationDTOConvert;
import com.xitianqujing.subject.application.convert.SubjectCategoryDTOConvert;
import com.xitianqujing.subject.application.convert.SubjectInfoDTOConvert;
import com.xitianqujing.subject.application.convert.SubjectLikedDTOConverter;
import com.xitianqujing.subject.application.dto.CommunicationDTO;
import com.xitianqujing.subject.application.dto.SubjectCategoryDTO;
import com.xitianqujing.subject.application.dto.SubjectInfoDTO;
import com.xitianqujing.subject.application.dto.SubjectLikedDTO;
import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.common.entity.Result;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.SubjectCategoryBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectLikedBO;
import com.xitianqujing.subject.domain.service.CommunicationDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 圈子controller
 */
@RestController
@RequestMapping("/subject/communication")
@Slf4j
public class CommunicationController {

    @Resource
    private CommunicationDomainService communicationDomainService;


    /**
     * 新增帖子
     * @param communicationDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody CommunicationDTO communicationDTO){
        try {
            //在高并发情况下，判断日志（log）是否启用级别（info级别）是一种常见的优化手段,将对象序列化为JSON字符串，从而减少不必要的性能开销。
            if(log.isInfoEnabled()){
                log.info("CommunicationController.add.dto:{}", JSON.toJSONString(communicationDTO));
            }
            Preconditions.checkNotNull(communicationDTO.getContent(), "帖子内容不能为空");
            CommunicationBO communicationBO = CommunicationDTOConvert.INSTANT.convertDtoToCommunicationBO(communicationDTO);
            communicationDomainService.add(communicationBO);
            return Result.ok(true);
        }catch (Exception e){
            log.error("CommunicationController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增帖子失败");
        }
    }

    /**
     * 查询帖子列表
     */
    @PostMapping("/getCommunicationPage")
    public Result<PageResult<CommunicationDTO>> getCommunicationPage(@RequestBody CommunicationDTO communicationDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommunicationController.getCommunicationPage.dto:{}", JSON.toJSONString(communicationDTO));
            }
            CommunicationBO communicationBO = CommunicationDTOConvert.INSTANT.convertDtoToCommunicationBO(communicationDTO);
            communicationBO.setPageNo(communicationDTO.getPageNo());
            communicationBO.setPageSize(communicationDTO.getPageSize());
            PageResult<CommunicationBO> boPageResult = communicationDomainService.getCommunicationPage(communicationBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("CommunicationController.getCommunicationPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询帖子失败");
        }
    }

    /**
     * 查询我发布的帖子
     */
    @PostMapping("/getMyPost")
    public Result<PageResult<CommunicationDTO>> getMyPost(@RequestBody CommunicationDTO communicationDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommunicationController.getMyPost.dto:{}", JSON.toJSONString(communicationDTO));
            }
            CommunicationBO communicationBO = CommunicationDTOConvert.INSTANT.convertDtoToCommunicationBO(communicationDTO);
            communicationBO.setPageNo(communicationDTO.getPageNo());
            communicationBO.setPageSize(communicationDTO.getPageSize());
            PageResult<CommunicationBO> boPageResult = communicationDomainService.getCommunicationByUser(communicationBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("CommunicationController.getMyPost.error:{}", e.getMessage(), e);
            return Result.fail("分页查询我发布的帖子失败");
        }
    }

    /**
     * 删除帖子
     * @param
     * @return
     */
    @PostMapping("/delete")
    public Result<List<Boolean>> delete(@RequestBody CommunicationDTO communicationDTO) {
        try {
            CommunicationBO communicationBO = CommunicationDTOConvert.INSTANT.convertDtoToCommunicationBO(communicationDTO);
            Boolean result = communicationDomainService.delete(communicationBO);
            return Result.ok(result);
        }catch (Exception e){
            log.error("CommunicationController.delete.error:{}",e.getMessage(),e);
            return Result.fail("删除帖子失败");
        }
    }

    /**
     * 查贴子
     * @param
     * @return
     */
    @PostMapping("/getcommunicationdetail")
    public Result<CommunicationDTO> getcommunicationdetail(@RequestBody CommunicationDTO communicationDTO) {
        try {
            CommunicationBO communicationBO = CommunicationDTOConvert.INSTANT.convertDtoToCommunicationBO(communicationDTO);
            CommunicationBO communicationBO1= communicationDomainService.getcommunicationdetail(communicationBO);
            CommunicationDTO communicationDTO1 =CommunicationDTOConvert.INSTANT.convertToDTO(communicationBO1);
            return Result.ok(communicationDTO1);
        }catch (Exception e){
            log.error("CommunicationController.delete.error:{}",e.getMessage(),e);
            return Result.fail("删除帖子失败");
        }
    }

}

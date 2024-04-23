package com.xitianqujing.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.xitianqujing.subject.application.convert.SubjectAnswerDTOConvert;
import com.xitianqujing.subject.application.convert.SubjectInfoDTOConvert;
import com.xitianqujing.subject.application.dto.SubjectInfoDTO;
import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.common.entity.Result;
import com.xitianqujing.subject.domain.entity.SubjectAnswerBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.service.SubjectInfoDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题controller
 */
@RestController
@Slf4j
@RequestMapping("/subject")
public class SubjectController {
    @Resource
    private SubjectInfoDomainService subjectInfoDomainService;

    /**
     * 新增题目
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            //防止因为高并发，而导致提前对log进行序列化
            if (log.isInfoEnabled()) {
                //打印日志
                log.info("SubjectInfoController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()),
                    "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectDifficult(),
                    "题目难度不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(),
                    "题目类型不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectScore(),
                    "题目分数不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),
                    "分类id不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),
                    "标签id不能为空");

            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANT.convertDTOToBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS = SubjectAnswerDTOConvert.INSTANT.convertListDTOToBO(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
            subjectInfoDomainService.add(subjectInfoBO);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增题目失败");
        }
    }

    /**
     * 查询题目列表
     */
    @PostMapping("/getSubjectPage")
    public Result<PageResult<SubjectInfoDTO>> getSubjectPage(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            //防止因为高并发，而导致提前对log进行序列化
            if (log.isInfoEnabled()) {
                //打印日志
                log.info("SubjectInfoController.getSubjectPage.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }

            Preconditions.checkNotNull(subjectInfoDTO.getCategoryId(),
                    "分类id不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getLabelId(),
                    "标签id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANT.
                    convertDTOToBO(subjectInfoDTO);
            PageResult<SubjectInfoBO> boPageResult = subjectInfoDomainService.getSubjectPage(subjectInfoBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("SubjectCategoryController.getSubjectPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询题目失败!");
        }
    }

    /**
     * 查询题目信息
     */
    @PostMapping("/querySubjectInfo")
    public Result<PageResult<SubjectInfoDTO>> querySubjectInfo(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                //打印日志
                log.info("SubjectInfoController.querySubjectInfo.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            Preconditions.checkNotNull(subjectInfoDTO.getId(),
                    "题目id不能为空");
            SubjectInfoBO subjectInfoBO = SubjectInfoDTOConvert.INSTANT.
                    convertDTOToBO(subjectInfoDTO);
            SubjectInfoBO boResult = subjectInfoDomainService.querySubjectInfo(subjectInfoBO);
            SubjectInfoDTO dto = SubjectInfoDTOConvert.INSTANT.
                    convertBOToDTO(boResult);
            return Result.ok(dto);
        } catch (Exception e) {
            log.error("SubjectCategoryController.querySubjectInfo.error:{}", e.getMessage(), e);
            return Result.fail("查询题目详情失败");
        }
    }
}

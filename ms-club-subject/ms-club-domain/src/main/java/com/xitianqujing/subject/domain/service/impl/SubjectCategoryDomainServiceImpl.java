package com.xitianqujing.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.domain.convert.SubjectCategoryConvert;
import com.xitianqujing.subject.domain.entity.SubjectCategoryBO;
import com.xitianqujing.subject.domain.entity.SubjectLabelBO;
import com.xitianqujing.subject.domain.service.SubjectCategoryDomainService;
import com.xitianqujing.subject.infra.basic.entity.SubjectCategory;
import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;
import com.xitianqujing.subject.infra.basic.entity.SubjectMapping;
import com.xitianqujing.subject.infra.basic.service.SubjectCategoryService;
import com.xitianqujing.subject.infra.basic.service.SubjectLabelService;
import com.xitianqujing.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private SubjectCategoryService subjectCategoryService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectLabelService subjectLabelService;

    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryList);
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectCategoryController.add.dto:{}",
                    JSON.toJSONString(boList));
        }
        boList.forEach(bo -> {
            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });
        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory = SubjectCategoryConvert.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count > 0;
    }

    @Override
    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {
        //查询当前大类下所有分类
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(subjectCategoryBO.getId());
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectCategoryController.queryCategoryAndLabel.dto:{}",
                    JSON.toJSONString(subjectCategoryList));
        }
        List<SubjectCategoryBO> categoryBOList = SubjectCategoryConvert.INSTANCE.convertBoToCategory(subjectCategoryList);
        //一次获取标签信息
        categoryBOList.forEach(category -> {
            SubjectMapping subjectMapping = new SubjectMapping();
            subjectMapping.setCategoryId(category.getId());
            List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
            if (CollectionUtils.isEmpty(mappingList)) {
                return;
            }
            List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
            List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
            List<SubjectLabelBO> labelBOList = new LinkedList<>();
            labelList.forEach(label -> {
                SubjectLabelBO subjectLableBO = new SubjectLabelBO();
                subjectLableBO.setId(label.getId());
                subjectLableBO.setLabelName(label.getLabelName());
                subjectLableBO.setCategoryId(label.getCategoryId());
                subjectLableBO.setSortNum(label.getSortNum());
                labelBOList.add(subjectLableBO);
            });
            category.setLabelBOList(labelBOList);
        });
        return categoryBOList;
    }
}
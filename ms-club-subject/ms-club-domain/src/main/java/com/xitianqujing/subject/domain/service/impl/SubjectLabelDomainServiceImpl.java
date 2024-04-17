package com.xitianqujing.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.domain.convert.SubjectLabelConvert;
import com.xitianqujing.subject.domain.entity.SubjectLabelBO;
import com.xitianqujing.subject.domain.service.SubjectLabelDomainService;
import com.xitianqujing.subject.infra.basic.entity.SubjectLabel;
import com.xitianqujing.subject.infra.basic.entity.SubjectMapping;
import com.xitianqujing.subject.infra.basic.service.SubjectLabelService;
import com.xitianqujing.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {
    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectLabelDomainServiceImpl.add.dto:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANTCE
                .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        int count = subjectLabelService.insert(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectLabelDomainServiceImpl.update.dto:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANTCE
                .convertBoToLabel(subjectLabelBO);
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            //打印日志
            log.info("SubjectLabelDomainServiceImpl.delete.dto:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConvert.INSTANTCE
                .convertBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectLabelService.update(subjectLabel);
        return count > 0;
    }

    @Override
    public List<SubjectLabelBO> queryLableByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId = subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return Collections.emptyList();
        }
        List<Long> lableIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> lableList = subjectLabelService.batchQueryById(lableIdList);
        List<SubjectLabelBO> boList = new LinkedList<>();
        lableList.forEach(label -> {
            SubjectLabelBO bo = new SubjectLabelBO();
            bo.setId(label.getId());
            bo.setLabelName(label.getLabelName());
            bo.setSortNum(label.getSortNum());
            bo.setCategoryId(categoryId);
            boList.add(bo);
        });
        return boList;
    }
}

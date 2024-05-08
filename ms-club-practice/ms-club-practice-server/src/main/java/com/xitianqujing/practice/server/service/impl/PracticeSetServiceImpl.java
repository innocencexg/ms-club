package com.xitianqujing.practice.server.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xitianqujing.practice.api.enums.SubjectInfoTypeEnum;
import com.xitianqujing.practice.api.vo.SpecialPracticeCategoryVO;
import com.xitianqujing.practice.api.vo.SpecialPracticeLabelVO;
import com.xitianqujing.practice.api.vo.SpecialPracticeVO;
import com.xitianqujing.practice.server.dao.SubjectCategoryDao;
import com.xitianqujing.practice.server.dao.SubjectLabelDao;
import com.xitianqujing.practice.server.dao.SubjectMappingDao;
import com.xitianqujing.practice.server.entity.dto.CategoryDTO;
import com.xitianqujing.practice.server.entity.po.CategoryPO;
import com.xitianqujing.practice.server.entity.po.LabelCountPO;
import com.xitianqujing.practice.server.entity.po.PrimaryCategoryPO;
import com.xitianqujing.practice.server.entity.po.SubjectLabelPO;
import com.xitianqujing.practice.server.service.PracticeSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class PracticeSetServiceImpl implements PracticeSetService {

    @Resource
    private SubjectCategoryDao subjectCategoryDao;
    @Resource
    private SubjectLabelDao subjectLabelDao;
    @Resource
    private SubjectMappingDao subjectMappingDao;

    @Override
    public List<SpecialPracticeVO> getSpecialPracticeContent() {
        List<SpecialPracticeVO> specialPracticeVOList = new LinkedList<>();
        List<Integer> subjectTypeList = new LinkedList<>();
        subjectTypeList.add(SubjectInfoTypeEnum.RADIO.getCode());
        subjectTypeList.add(SubjectInfoTypeEnum.MULTIPLE.getCode());
        subjectTypeList.add(SubjectInfoTypeEnum.JUDGE.getCode());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setSubjectTypeList(subjectTypeList);
        List<PrimaryCategoryPO> poList = subjectCategoryDao.getPrimaryCategory(categoryDTO);
        if (CollectionUtils.isEmpty(poList)) {
            return specialPracticeVOList;
        }
        poList.forEach(primaryCategoryPO -> {
            SpecialPracticeVO specialPracticeVO = new SpecialPracticeVO();
            specialPracticeVO.setPrimaryCategoryId(primaryCategoryPO.getParentId());
            CategoryPO categoryPO = subjectCategoryDao.selectById(primaryCategoryPO.getParentId());
            specialPracticeVO.setPrimaryCategoryName(categoryPO.getCategoryName());
            CategoryDTO categoryDTOTemp = new CategoryDTO();
            categoryDTOTemp.setCategoryType(2);
            categoryDTOTemp.setParentId(primaryCategoryPO.getParentId());
            List<CategoryPO> smallPoList = subjectCategoryDao.selectList(categoryDTOTemp);
            if (CollectionUtils.isEmpty(smallPoList)) {
                return;
            }
            List<SpecialPracticeCategoryVO> categoryList = new LinkedList();
            smallPoList.forEach(smallPo -> {
                List<SpecialPracticeLabelVO> labelVOList = getLabelVOList(smallPo.getId(), subjectTypeList);
                if (CollectionUtils.isEmpty(labelVOList)) {
                    return;
                }
                SpecialPracticeCategoryVO specialPracticeCategoryVO = new SpecialPracticeCategoryVO();
                specialPracticeCategoryVO.setCategoryId(smallPo.getId());
                specialPracticeCategoryVO.setCategoryName(smallPo.getCategoryName());
                List<SpecialPracticeLabelVO> labelList = new LinkedList<>();
                labelVOList.forEach(labelVo -> {
                    SpecialPracticeLabelVO specialPracticeLabelVO = new SpecialPracticeLabelVO();
                    specialPracticeLabelVO.setId(labelVo.getId());
                    specialPracticeLabelVO.setAssembleId(labelVo.getAssembleId());
                    specialPracticeLabelVO.setLabelName(labelVo.getLabelName());
                    labelList.add(specialPracticeLabelVO);
                });
                specialPracticeCategoryVO.setLabelList(labelList);
                categoryList.add(specialPracticeCategoryVO);
            });
            specialPracticeVO.setCategoryList(categoryList);
            specialPracticeVOList.add(specialPracticeVO);
        });
        return specialPracticeVOList;
    }

    private List<SpecialPracticeLabelVO> getLabelVOList(Long categoryId, List<Integer> subjectTypeList) {
        List<LabelCountPO> countPOList = subjectMappingDao.getLabelSubjectCount(categoryId, subjectTypeList);
        if (CollectionUtils.isEmpty(countPOList)) {
            return Collections.emptyList();
        }
        List<SpecialPracticeLabelVO> voList = new LinkedList<>();
        countPOList.forEach(countPo -> {
            SpecialPracticeLabelVO vo = new SpecialPracticeLabelVO();
            vo.setId(countPo.getLabelId());
            vo.setAssembleId(categoryId + "-" + countPo.getLabelId());
            SubjectLabelPO subjectLabelPO = subjectLabelDao.queryById(countPo.getLabelId());
            vo.setLabelName(subjectLabelPO.getLabelName());
            voList.add(vo);
        });
        return voList;
    }



}
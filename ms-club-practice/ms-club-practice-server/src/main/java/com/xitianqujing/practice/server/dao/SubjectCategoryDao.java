package com.xitianqujing.practice.server.dao;

import com.xitianqujing.practice.server.entity.dto.CategoryDTO;
import com.xitianqujing.practice.server.entity.po.CategoryPO;
import com.xitianqujing.practice.server.entity.po.PrimaryCategoryPO;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表数据库访问层
 *
 */
public interface SubjectCategoryDao {

    List<PrimaryCategoryPO> getPrimaryCategory(CategoryDTO categoryDTO);

    CategoryPO selectById(Long id);

    List<CategoryPO> selectList(CategoryDTO categoryDTOTemp);

}

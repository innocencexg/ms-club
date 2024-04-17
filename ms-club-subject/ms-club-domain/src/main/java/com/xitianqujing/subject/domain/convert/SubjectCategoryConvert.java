package com.xitianqujing.subject.domain.convert;

import com.xitianqujing.subject.domain.entity.SubjectCategoryBO;
import com.xitianqujing.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface SubjectCategoryConvert {

    SubjectCategoryConvert INSTANCE = Mappers.getMapper(SubjectCategoryConvert.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
    SubjectCategoryBO convertBoToCategory(SubjectCategory categoryList);
    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);
}

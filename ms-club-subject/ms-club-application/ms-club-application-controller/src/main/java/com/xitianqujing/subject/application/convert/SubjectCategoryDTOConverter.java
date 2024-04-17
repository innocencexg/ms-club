package com.xitianqujing.subject.application.convert;

import com.xitianqujing.subject.application.dto.SubjectCategoryDTO;
import com.xitianqujing.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);
    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);
    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);
    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);
}

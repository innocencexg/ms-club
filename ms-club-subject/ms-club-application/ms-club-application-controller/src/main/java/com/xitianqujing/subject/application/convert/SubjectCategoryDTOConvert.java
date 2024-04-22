package com.xitianqujing.subject.application.convert;


import com.xitianqujing.subject.application.dto.SubjectCategoryDTO;
import com.xitianqujing.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConvert {
    SubjectCategoryDTOConvert INSTANT = Mappers.getMapper(SubjectCategoryDTOConvert.class);

    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);

    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);

}

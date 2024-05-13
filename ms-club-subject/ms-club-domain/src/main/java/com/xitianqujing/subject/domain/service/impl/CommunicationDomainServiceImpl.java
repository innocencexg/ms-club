package com.xitianqujing.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.common.enums.IsDeletedFlagEnum;
import com.xitianqujing.subject.common.util.LoginUtil;
import com.xitianqujing.subject.domain.convert.CommunicationConvert;
import com.xitianqujing.subject.domain.convert.SubjectCategoryConvert;
import com.xitianqujing.subject.domain.convert.SubjectInfoConvert;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.SubjectInfoBO;
import com.xitianqujing.subject.domain.entity.SubjectLikedBO;
import com.xitianqujing.subject.domain.service.CommunicationDomainService;
import com.xitianqujing.subject.infra.basic.entity.Communication;
import com.xitianqujing.subject.infra.basic.entity.SubjectCategory;
import com.xitianqujing.subject.infra.basic.entity.SubjectInfo;
import com.xitianqujing.subject.infra.basic.entity.SubjectLiked;
import com.xitianqujing.subject.infra.basic.service.CommunicationService;
import com.xitianqujing.subject.infra.basic.service.SubjectInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Service
public class CommunicationDomainServiceImpl implements CommunicationDomainService {

    @Resource
    private CommunicationService communicationService;

    public void add(CommunicationBO communicationBO){
        if(log.isInfoEnabled()){
            log.info("CommunicationController.add.bo:{}", JSON.toJSONString(communicationBO));
        }
        Communication communication = CommunicationConvert.INSTANCE.convertBoToCommunication(communicationBO);
        String userName = communicationService.querybyUserId(LoginUtil.getLoginId());
        String url = communicationService.queryurl(LoginUtil.getLoginId());
        communication.setCreatedBy(userName);
        communication.setAvatar(url);
        communicationService.insert(communication);
    }

    @Override
    public PageResult<CommunicationBO> getCommunicationPage(CommunicationBO communicationBO) {
        PageResult<CommunicationBO> pageResult = new PageResult<>();
        pageResult.setPageNo(communicationBO.getPageNo());
        pageResult.setPageSize(communicationBO.getPageSize());
        int start = (communicationBO.getPageNo() - 1) * communicationBO.getPageSize();
        Communication communication = CommunicationConvert.INSTANCE.convertBoToCommunication(communicationBO);
        int count = communicationService.countByCondition(communication);
        if (count == 0) {
            return pageResult;
        }
        List<Communication> communicationList = communicationService.quertPage(communication, start,communicationBO.getPageSize());
        List<CommunicationBO> communicationBOS = CommunicationConvert.INSTANCE.convertListToBO(communicationList);
        pageResult.setRecords(communicationBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public PageResult<CommunicationBO> getCommunicationByUser(CommunicationBO communicationBO) {
        PageResult<CommunicationBO> pageResult = new PageResult<>();
        pageResult.setPageNo(communicationBO.getPageNo());
        pageResult.setPageSize(communicationBO.getPageSize());
        int start = (communicationBO.getPageNo() - 1) * communicationBO.getPageSize();
        Communication communication = CommunicationConvert.INSTANCE.convertBoToCommunication(communicationBO);
        String userName = communicationService.querybyUserId(LoginUtil.getLoginId());
        communication.setCreatedBy(userName);
        int count = communicationService.countByCondition(communication);
        if (count == 0) {
            return pageResult;
        }
        List<Communication> communicationList = communicationService.quertPageByUser(userName, start, communicationBO.getPageSize());
        List<CommunicationBO> communicationBOS = CommunicationConvert.INSTANCE.convertListToBO(communicationList);
        pageResult.setRecords(communicationBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public Boolean delete(CommunicationBO communicationBO) {
        Communication communication = CommunicationConvert.INSTANCE.convertBoToCommunication(communicationBO);
        int count  = communicationService.deleteByUser(communication.getId());
        return count > 0;
    }

    @Override
    public CommunicationBO getcommunicationdetail(CommunicationBO communicationBO) {
        Communication communication = CommunicationConvert.INSTANCE.convertBoToCommunication(communicationBO);
        Communication communication1=communicationService.getcommunicationdetail(communication.getId());
        CommunicationBO communicationBO1 =CommunicationConvert.INSTANCE.convertToBO(communication1);

        return  communicationBO1;
    }
}

package com.xitianqujing.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.common.util.LoginUtil;
import com.xitianqujing.subject.domain.convert.CommentConvert;
import com.xitianqujing.subject.domain.convert.CommunicationConvert;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.CommunicationSubBO;
import com.xitianqujing.subject.domain.service.CommunicationDomainService;
import com.xitianqujing.subject.domain.service.CommunicationSubDomainService;
import com.xitianqujing.subject.infra.basic.entity.Communication;
import com.xitianqujing.subject.infra.basic.entity.CommunicationSub;
import com.xitianqujing.subject.infra.basic.service.CommunicationService;
import com.xitianqujing.subject.infra.basic.service.CommunicationSubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Service
public class CommunicationSubDomainServiceImpl implements CommunicationSubDomainService {
    @Resource
    private CommunicationSubService communicationSubService;
    @Resource
    private CommunicationService communicationService;

    @Override
    public void add(CommunicationSubBO communicationSubBO) {
        if(log.isInfoEnabled()){
            log.info("CommunicationSubController.add.bo:{}", JSON.toJSONString(communicationSubBO));
        }
        CommunicationSub communicationSub = CommentConvert.INSTANCE.convertBoToCommunicationSub(communicationSubBO);
        String userName = communicationService.querybyUserId(LoginUtil.getLoginId());
        communicationSub.setCreatedBy(userName);
        communicationSubService.insert(communicationSub);
    }


    @Override
    public PageResult<CommunicationSubBO> getCommentPage(CommunicationSubBO communicationSubBO) {
        PageResult<CommunicationSubBO> pageResult = new PageResult<>();
        pageResult.setPageNo(communicationSubBO.getPageNo());
        pageResult.setPageSize(communicationSubBO.getPageSize());
        int start = (communicationSubBO.getPageNo() - 1) * communicationSubBO.getPageSize();
        CommunicationSub communicationSub = CommentConvert.INSTANCE.convertBoToCommunicationSub(communicationSubBO);
        int count = communicationSubService.countByCondition(communicationSub.getParentId());
        if (count == 0) {
            return pageResult;
        }
        List<CommunicationSub> communicationSubList = communicationSubService.quertPage(communicationSub.getParentId(), start,communicationSubBO.getPageSize());
        List<CommunicationSubBO> communicationSubBOS = CommentConvert.INSTANCE.convertListToBO(communicationSubList);
        pageResult.setRecords(communicationSubBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public PageResult<CommunicationSubBO> getCommentByUser(CommunicationSubBO communicationSubBO) {
        PageResult<CommunicationSubBO> pageResult = new PageResult<>();
        pageResult.setPageNo(communicationSubBO.getPageNo());
        pageResult.setPageSize(communicationSubBO.getPageSize());
        int start = (communicationSubBO.getPageNo() - 1) * communicationSubBO.getPageSize();
        CommunicationSub communicationSub = CommentConvert.INSTANCE.convertBoToCommunicationSub(communicationSubBO);
        String userName = communicationService.querybyUserId(LoginUtil.getLoginId());
        communicationSub.setCreatedBy(userName);
        int count = communicationSubService.countByCondition(communicationSub.getParentId());
        if (count == 0) {
            return pageResult;
        }
        List<CommunicationSub> communicationSubList = communicationSubService.quertPageByUser(userName, start, communicationSubBO.getPageSize());
        List<CommunicationSubBO> communicationSubBOS = CommentConvert.INSTANCE.convertListToBO(communicationSubList);
        pageResult.setRecords(communicationSubBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public Boolean deleteComment(CommunicationSubBO communicationSubBO) {
        CommunicationSub communicationSub = CommentConvert.INSTANCE.convertBoToCommunicationSub(communicationSubBO);
        int count  = communicationSubService.deleteById(communicationSub.getId());
        return count > 0;
    }
}

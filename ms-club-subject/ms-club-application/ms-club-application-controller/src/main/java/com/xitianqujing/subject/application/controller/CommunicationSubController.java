package com.xitianqujing.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.xitianqujing.subject.application.convert.CommentDTOConvert;
import com.xitianqujing.subject.application.convert.CommunicationDTOConvert;
import com.xitianqujing.subject.application.dto.CommunicationDTO;
import com.xitianqujing.subject.application.dto.CommunicationSubDTO;
import com.xitianqujing.subject.common.entity.PageResult;
import com.xitianqujing.subject.common.entity.Result;
import com.xitianqujing.subject.domain.entity.CommunicationBO;
import com.xitianqujing.subject.domain.entity.CommunicationSubBO;
import com.xitianqujing.subject.domain.service.CommunicationSubDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论controller
 */
@RestController
@RequestMapping("/subject/comment")
@Slf4j
public class CommunicationSubController {

    @Resource
    private CommunicationSubDomainService communicationSubDomainService;

    /**
     * 新增评论
     * @param communicationSubDTO
     * @return
     */
    @PostMapping("/addcomment")
    public Result<Boolean> add(@RequestBody CommunicationSubDTO communicationSubDTO){
        try {
            //在高并发情况下，判断日志（log）是否启用级别（info级别）是一种常见的优化手段,将对象序列化为JSON字符串，从而减少不必要的性能开销。
            if(log.isInfoEnabled()){
                log.info("CommunicationSubController.addcomment.dto:{}", JSON.toJSONString(communicationSubDTO));
            }
            Preconditions.checkNotNull(communicationSubDTO.getContent(), "评论内容不能为空");
            CommunicationSubBO communicationSubBO = CommentDTOConvert.INSTANCE.communicationSubBO(communicationSubDTO);
            communicationSubDomainService.add(communicationSubBO);
            return Result.ok(true);
        }catch (Exception e){
            log.error("CommunicationSubController.addcomment.error:{}", e.getMessage(), e);
            return Result.fail("新增评论失败");
        }
    }

    /**
     * 查询评论列表
     */
    @PostMapping("/getCommentPage")
    public Result<PageResult<CommunicationSubDTO>> getCommentPage(@RequestBody CommunicationSubDTO communicationSubDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommunicationSubController.getCommentPage.dto:{}", JSON.toJSONString(communicationSubDTO));
            }
            CommunicationSubBO communicationSubBO = CommentDTOConvert.INSTANCE.communicationSubBO(communicationSubDTO);
            communicationSubBO.setPageNo(communicationSubDTO.getPageNo());
            communicationSubBO.setPageSize(communicationSubDTO.getPageSize());
            PageResult<CommunicationSubBO> boPageResult = communicationSubDomainService.getCommentPage(communicationSubBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("CommunicationSubController.getCommentPage.error:{}", e.getMessage(), e);
            return Result.fail("分页查询评论失败");
        }
    }

    /**
     * 查询我发布的评论
     */
    @PostMapping("/getMyComment")
    public Result<PageResult<CommunicationSubDTO>> getMyComment(@RequestBody CommunicationSubDTO communicationSubDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CommunicationSubController.getMyComment.dto:{}", JSON.toJSONString(communicationSubDTO));
            }
            CommunicationSubBO communicationSubBO = CommentDTOConvert.INSTANCE.communicationSubBO(communicationSubDTO);
            communicationSubBO.setPageNo(communicationSubDTO.getPageNo());
            communicationSubBO.setPageSize(communicationSubDTO.getPageSize());
            PageResult<CommunicationSubBO> boPageResult = communicationSubDomainService.getCommentByUser(communicationSubBO);
            return Result.ok(boPageResult);
        } catch (Exception e) {
            log.error("CommunicationController.getMyPost.error:{}", e.getMessage(), e);
            return Result.fail("分页查询我发布的帖子失败");
        }
    }
    /**
     * 删除评论
     * @param
     * @return
     */
    @PostMapping("/deleteComment")
    public Result<List<Boolean>> deleteComment(@RequestBody CommunicationSubDTO communicationSubDTO) {
        try {
            CommunicationSubBO communicationSubBO = CommentDTOConvert.INSTANCE.communicationSubBO(communicationSubDTO);
            Boolean result = communicationSubDomainService.deleteComment(communicationSubBO);
            return Result.ok(result);
        }catch (Exception e){
            log.error("CommunicationController.deleteComment.error:{}",e.getMessage(),e);
            return Result.fail("删除评论失败");
        }
    }


}

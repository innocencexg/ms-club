package com.xitianqujing.subject.common.enums;
import lombok.Getter;

/**
 * @Author: gx
 * @CreateTime: 2024/04/22  16:06
 */
@Getter
public enum SubjectLikedStatusEnum {

    LIKED(1, "点赞"),
    UN_LIKED(0, "取消点赞");

    public int code;

    public String desc;

    SubjectLikedStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static SubjectLikedStatusEnum getByCode(int codeVal) {
        for (SubjectLikedStatusEnum resultCodeEnum : SubjectLikedStatusEnum.values()) {
            if (resultCodeEnum.code == codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }

}

package com.xitianqujing.auth.common.enums;

import lombok.Getter;

/**
 * 删除状态枚举
 */
@Getter
public enum IsDeletedFlagEnum {

    DELETED(1,"已删除"),
    UN_DELETED(0,"未删除");

    private int code;

    private String desc;

    IsDeletedFlagEnum(int code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal){
        for(IsDeletedFlagEnum resultCodeEUM: IsDeletedFlagEnum.values()){
            if(resultCodeEUM.code == codeVal){
                return resultCodeEUM;
            }
        }
        return null;
    }

}

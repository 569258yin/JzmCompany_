package com.jinzhimu.company.databean;

/**
 * Created by MyPC on 2017/6/17.
 */
public enum HttpResultType {
    SUCCESS(1001,"成功")
    ,FAILD(1000,"失败")
    ;

    private int code;
    private String message;


    HttpResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

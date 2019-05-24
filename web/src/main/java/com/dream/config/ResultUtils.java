package com.dream.config;

import lombok.Data;

import java.io.Serializable;

public class ResultUtils {
    public static Object success(Object data){
        return new Result<Object>(200,"success",data);
    }
    public static Object fail(Object data){
        return new Result<Object>(500,"error",data);
    }
}
@Data
class Result<T> implements Serializable{
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

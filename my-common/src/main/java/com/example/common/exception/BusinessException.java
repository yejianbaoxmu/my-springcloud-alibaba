package com.example.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.exception.BusinessException
 * @Date: 2022年06月09日 14:03
 * @Description:
 */
@Getter
@Setter
public class BusinessException extends Exception{

    private int code = 9999;
    private String message;

    public BusinessException(String message){
        super(message);
        this.message = message;
    }

    public BusinessException(int code,String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
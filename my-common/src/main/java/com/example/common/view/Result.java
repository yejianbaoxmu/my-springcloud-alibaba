package com.example.common.view;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.view.Result
 * @Date: 2022年06月01日 14:37
 * @Description:
 */
@Getter
@Setter
public class Result {

    private int code = -999999;
    private String message;
    private Object data;

    public  Result(int code,String message){
        this.code = code;
        this.message = message;
    }

    public  Result(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
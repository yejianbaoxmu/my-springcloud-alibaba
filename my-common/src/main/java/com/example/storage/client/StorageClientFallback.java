package com.example.storage.client;

import com.alibaba.fastjson.JSON;
import com.example.common.entity.Storage;
import com.example.common.view.Result;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.order.service.StorageClientFallback
 * @Date: 2022年06月01日 14:54
 * @Description:
 */
public class StorageClientFallback implements StorageClient {

    private Throwable throwable;

    StorageClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String substract(Storage storage)  {
        Result result = new Result(-9999,"fail back"+throwable.toString());
        return JSON.toJSONString(result);
    }
}
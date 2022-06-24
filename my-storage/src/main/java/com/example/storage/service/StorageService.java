package com.example.storage.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.common.entity.Storage;
import com.example.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.storage.service.StorageService
 * @Date: 2022年06月09日 11:41
 * @Description:
 */
@Service
@Slf4j
public class StorageService {

    @SentinelResource(value = "substract",blockHandler = "blockHandlerForSubstract",
            fallback = "failBackForSubstract")
    public void substract(Storage storage) throws BusinessException {
        System.out.println("进行库存扣减substract begin");
        System.out.println("sleep 500ms");
        try {
            //睡眠10s
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new BusinessException(6666,e.toString());
        }
        System.out.println("库存正常扣减substract success");
    }

    public void blockHandlerForSubstract(Storage storage, BlockException blockException)throws BusinessException{
        log.error(blockException.toString());
        throw new BusinessException("库存扣减服务异常:"+blockException.toString());
    }

    public void failBackForSubstract(Storage storage){
        System.out.println("啥也不做");
    }
}
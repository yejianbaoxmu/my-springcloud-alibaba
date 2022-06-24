package com.example.order.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.order.service.StorageServiceFallbackFactory
 * @Date: 2022年06月09日 16:30
 * @Description:
 */
@Component
public class StorageServiceFallbackFactory implements FallbackFactory<StorageServiceFallback> {
    @Override
    public StorageServiceFallback create(Throwable cause) {
        return new StorageServiceFallback(cause);
    }
}
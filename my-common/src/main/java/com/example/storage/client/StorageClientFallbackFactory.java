package com.example.storage.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.fallback.StorageClientFallbackFactory
 * @Date: 2022年06月09日 15:44
 * @Description:
 */
@Component
public class StorageClientFallbackFactory implements FallbackFactory<StorageClientFallback> {
    @Override
    public StorageClientFallback create(Throwable cause) {

        return new StorageClientFallback(cause);
    }
}
package com.example.storage.client;

import com.example.common.entity.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.client.StorageClient
 * @Date: 2022年06月02日 15:07
 * @Description:
 */
@FeignClient(name = "storage", fallbackFactory = StorageClientFallbackFactory.class)
public interface StorageClient {


    @PostMapping("/storage/substract")
    String substract(@RequestBody Storage storage) ;
}
package com.example.order.service;

import com.example.common.entity.Storage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "storage", fallbackFactory = StorageServiceFallbackFactory.class)
public interface StorageService {

    @PostMapping("/storage/substract")
    String substract(@RequestBody Storage storage);
}

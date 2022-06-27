package com.example.storage.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.entity.Storage;
import com.example.common.exception.BusinessException;
import com.example.common.view.Result;
import com.example.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.storage.controller.StorageController
 * @Date: 2022年06月01日 14:31
 * @Description:
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/status")
    public String status(){
        storageService.status();
        Result result = new Result(0,"状态正常",null);
        return JSON.toJSONString(result);
    }
    /**
    *@Param:
    *@return:
    *@Author: yejb
    *@date: 2022/6/1 14:35
    */
    @PostMapping("/substract")
    public String substract(@RequestBody Storage storage){
        Result result = null;
        try {
            storageService.substract(storage);
            result = new Result(0,"库存扣减成功",null);
        } catch (BusinessException e) {
            result = new Result(e.getCode(),e.getMessage());
        }
        return JSON.toJSONString(result);
    }

    @GetMapping("/services/{service}")
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }
}
package com.example.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.view.Result;
import com.example.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.gateway.controller.GatewayController
 * @Date: 2022年06月24日 16:47
 * @Description:
 */
@RequestMapping("/gateway")
@ResponseBody
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @GetMapping("/status")
    public String status(){
        gatewayService.status();
        Result result = new Result(0,"状态正常",null);
        return JSON.toJSONString(result);
    }
}
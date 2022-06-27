package com.example.order.controller;

import com.alibaba.fastjson.JSON;
import com.example.common.entity.Account;
import com.example.common.entity.Storage;
import com.example.common.view.Result;
import com.example.order.service.OrderService;
import com.example.order.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.order.controller.OrderController
 * @Date: 2022年06月01日 10:17
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/status")
    public String status(){
        Result result = new Result(0,"状态正常",null);
        orderService.status();
        return JSON.toJSONString(result);
    }

    @PostMapping("/create")
    public String create(String userId,String commodityCode,int orderCount){

        System.out.println("创建订单 order create begin!!!!!!!!!");
        //减去账户钱
        Account account = new Account();
        account.setUserId(userId);

        //
        Storage storage = new Storage();
        storage.setCommodityCode(commodityCode);
        storage.setCount(orderCount);
        String resultStorage = storageService.substract(storage);
        System.out.println(resultStorage);

        Result result = new Result(0,"订单创建成功",null);

        System.out.println("创建订单 order create success!!!!!!!");
        return JSON.toJSONString(result);
    }
}
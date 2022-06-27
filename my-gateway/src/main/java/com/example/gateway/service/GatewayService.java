package com.example.gateway.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.gateway.service.GatewayService
 * @Date: 2022年06月24日 16:48
 * @Description:
 */
@Service
@Slf4j
public class GatewayService {

    public void status(){
        System.out.println("gateway状态status begin");
        System.out.println("sleep 125ms");
        try {
            //睡眠10s
            Thread.sleep(125);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("gateway状态status success");
    }
}
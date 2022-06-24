package com.example.common.entity;

import lombok.Data;

/**
 * @author: yejianbao
 * @Project: my
 * @Package: com.example.common.entity.Order
 * @Date: 2022年06月01日 11:39
 * @Description:
 */
@Data
public class Order {

    private int id;
    private String userId;
    private String commodityCode;
    private int count;
    private int money;
}
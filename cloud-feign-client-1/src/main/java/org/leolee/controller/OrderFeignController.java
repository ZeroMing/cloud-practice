package org.leolee.controller;

import org.leolee.service.LeoLeeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月05 20时53分
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    LeoLeeFeign leoLeeFeign;

    @GetMapping("/order/{orderId}")
    public String getDate( @PathVariable String orderId ) {
        return leoLeeFeign.order(orderId);
    }
}
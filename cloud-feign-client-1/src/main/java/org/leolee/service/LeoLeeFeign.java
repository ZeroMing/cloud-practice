package org.leolee.service;

import org.leolee.fallback.FeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月05 20时31分
 */
@FeignClient(value = "leolee-client",fallback = FeignClientFallback.class)
public interface LeoLeeFeign {

    @RequestMapping("/order/{orderId}")
    public String order(@PathVariable String orderId);
}

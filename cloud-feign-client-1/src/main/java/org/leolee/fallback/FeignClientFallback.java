package org.leolee.fallback;

import org.leolee.service.LeoLeeFeign;
import org.springframework.stereotype.Component;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月05 20时32分
 */
@Component
public class FeignClientFallback implements LeoLeeFeign {
    @Override
    public String order(String orderId) {
        System.out.println("熔断，默认回调函数");
        return "熔断，默认回调函数";
    }
}

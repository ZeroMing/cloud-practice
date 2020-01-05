package org.leolee.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.leolee.config.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月03 23时27分
 */
@RestController
@RibbonClient(name = "leolee-client",configuration = RibbonConfig.class)
@DefaultProperties(defaultFallback = "defaultFail")
public class LeoLeeController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/org.leolee.service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    /*@HystrixCommand(fallbackMethod = "orderFail1",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1"),
                    @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
            }
    )*/
    @RequestMapping("/order/{orderId}")
    public String order(@PathVariable String orderId) throws InterruptedException {
        return orderId+"2222222222222";
    }

    @HystrixCommand(fallbackMethod = "orderFail2")
    private String orderFail1(String orderId) {
        System.out.println("orderFail1");
        int i = 1/0;
        return "orderFail1";
    }


    private String orderFail2(String orderId) {
        System.out.println("orderFail2");
        return "orderFail2";
    }



    private String defaultFail() {
        System.out.println("default fail");
        return "default fail";
    }
}


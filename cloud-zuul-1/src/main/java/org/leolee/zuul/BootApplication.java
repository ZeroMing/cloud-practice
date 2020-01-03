package org.leolee.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月03 22时49分
 */

@SpringBootApplication
@EnableZuulProxy
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class,args);
    }
}

package org.leolee.zuul;

import org.leolee.zuul.filter.LeoLeeAuthorizedZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月06 01时06分
 */
@Configuration
public class ZuulConfig {
    @Bean
    public LeoLeeAuthorizedZuulFilter authorizedZuulFilter(){
        return new LeoLeeAuthorizedZuulFilter();
    }
}

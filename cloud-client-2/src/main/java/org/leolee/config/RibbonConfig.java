package org.leolee.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月05 23时45分
 */
@Configuration
public class RibbonConfig {
    @Bean
    public IRule myRule(){
        // 自定义均衡策略
        return new RandomRule();
    }
}

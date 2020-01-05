package org.leolee;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月03 23时07分
 */
@SpringBootApplication
@EnableEurekaServer
public class Server3Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Server3Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }

}

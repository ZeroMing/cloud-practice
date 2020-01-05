package org.leolee.zuul;

/**
 * @author: zeroming@163.com
 * @version:
 * @date: 2020年01月05 19时53分
 */

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 网关熔断配置
 *
 * @author zhyu
 * @version v1.0
 * @date 2018年07月03日 19:54:28
 */
@Component
public class LeoLeeZuulFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        //实现对producer-server服务的熔断
        return "producer-server";
        //return "*";  实现对所有的路由服务的熔断
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("{\"status\":500,\"message\":\"sorry,the system goes to sleep,please try again later!\"}".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }


}

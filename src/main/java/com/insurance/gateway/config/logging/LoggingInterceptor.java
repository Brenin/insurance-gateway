package com.insurance.gateway.config.logging;

import com.insurance.gateway.util.LoggingUtil;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        LoggingUtil.logInfo("Headers: {}"       , request.getHeaders());
        LoggingUtil.logInfo("Request Method: {}", request.getMethod());
        LoggingUtil.logInfo("Request URI: {}"   , request.getURI());

        return execution.execute(request, body);
    }
}

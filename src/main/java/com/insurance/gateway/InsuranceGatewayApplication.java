package com.insurance.gateway;

import com.insurance.gateway.util.LoggingUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InsuranceGatewayApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceGatewayApplication.class, args);

        LoggingUtil.logInfo("--------------------------------------------------");
        LoggingUtil.logInfo(InsuranceGatewayApplication.class.getSimpleName() + " started successfully in embedded tomcat");
        LoggingUtil.logInfo("--------------------------------------------------");
    }

}

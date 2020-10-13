package com.insurance.gateway.config;

import javax.ws.rs.core.Application;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/insurance_gateway/")
public class WebConfig extends Application {

}

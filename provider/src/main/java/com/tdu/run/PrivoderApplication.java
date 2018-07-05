package com.tdu.run;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringCloudApplication
@ComponentScan(basePackages = "com.tdu.web")
public class PrivoderApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PrivoderApplication.class, args);
    }

}

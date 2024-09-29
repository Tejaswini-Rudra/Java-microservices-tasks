package com.cloud;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekacloudeserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekacloudeserverApplication.class, args);
	}

}

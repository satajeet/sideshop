package com.sideshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SideshopEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(SideshopEurekaServer.class, args);
	}

}

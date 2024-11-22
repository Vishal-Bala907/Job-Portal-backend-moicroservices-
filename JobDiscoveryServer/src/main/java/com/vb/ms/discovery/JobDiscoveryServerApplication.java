package com.vb.ms.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JobDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobDiscoveryServerApplication.class, args);
	}

}

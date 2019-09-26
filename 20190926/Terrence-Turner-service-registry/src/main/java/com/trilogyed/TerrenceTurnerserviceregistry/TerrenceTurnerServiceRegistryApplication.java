package com.trilogyed.TerrenceTurnerserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TerrenceTurnerServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrenceTurnerServiceRegistryApplication.class, args);
	}

}

package com.trilogyed.TerrenceTurnermagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TerrenceTurnerMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerrenceTurnerMagicEightBallServiceApplication.class, args);
	}

}

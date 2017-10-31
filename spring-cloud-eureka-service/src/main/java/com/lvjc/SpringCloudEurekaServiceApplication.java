package com.lvjc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServiceApplication.class, args);
	}
}

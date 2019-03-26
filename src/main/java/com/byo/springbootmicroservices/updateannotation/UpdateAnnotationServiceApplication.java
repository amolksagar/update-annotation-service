package com.byo.springbootmicroservices.updateannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.byo.springbootmicroservices.updateannotation")
@EnableDiscoveryClient
public class UpdateAnnotationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateAnnotationServiceApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}

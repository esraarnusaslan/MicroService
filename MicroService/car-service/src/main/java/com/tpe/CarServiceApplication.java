package com.tpe;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.NamingConvention;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
				.setFieldMatchingEnabled(true) // !!! fieldlar otomatik olarak eslessin
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE) // !!! private fieldlar eslessin
				.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

		return modelMapper;
	}

	@Bean
	// !!! RestTemplate , Client gibi request olusturmamizi sagliyor
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
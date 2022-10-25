package com.sideshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableMongoRepositories
@EnableSwagger2
@EnableTransactionManagement
public class SideshopApplication {

    public static void main(String[] args) {
	SpringApplication.run(SideshopApplication.class, args);
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
	return new MongoTransactionManager(mongoDatabaseFactory);
    }

    @Bean
    public Docket sideshopAPI() {
	return new Docket(DocumentationType.SWAGGER_2).select()
		.apis(RequestHandlerSelectors.basePackage("com.sideshop.project.v1.api")).build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/").allowedOrigins("http://localhost:8080");
	    }
	};
    }

}

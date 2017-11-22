package com.example.demo;

import com.example.demo.config.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.demo.config","com.example.demo.controller"})
//@EntityScan("com.example.demo.model")
//@EnableJpaRepositories("com.example.demo.repository")
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})

public class CrudDemoApplication {
	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(CrudDemoApplication.class, args);
		SpringContextUtil.setApplicationContext(app);
	}
}


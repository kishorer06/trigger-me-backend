package com.triggerme.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
public class TriggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriggerApplication.class, args);
	}
}

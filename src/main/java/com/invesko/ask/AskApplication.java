package com.invesko.ask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.invesko.ask.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.invesko.ask"})
public class AskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskApplication.class, args);
	}

}


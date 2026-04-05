package com.debmalya.financial_data_processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FinancialDataProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialDataProcessingApplication.class, args);
	}

}

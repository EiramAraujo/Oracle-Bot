package com.chiron.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chiron.utils.ExcelReader;

@SpringBootApplication
public class ChironApplication {
	
	@Bean(initMethod="getUnits")
	public ExcelReader exMeth() {
		return ExcelReader.getInstance();
	}

	public static void main(String[] args) {
		SpringApplication.run(ChironApplication.class, args);
	}

}

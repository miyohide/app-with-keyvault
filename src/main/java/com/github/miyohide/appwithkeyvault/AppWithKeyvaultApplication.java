package com.github.miyohide.appwithkeyvault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppWithKeyvaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppWithKeyvaultApplication.class, args);
	}

	@GetMapping("get")
	public String get() {
		return connectionString;
	}

	// Azure Key Vaultのシークレットから値を取得する
	@Value("${connectionString}")
	private String connectionString;
}

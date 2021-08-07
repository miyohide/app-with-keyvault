package com.github.miyohide.appwithkeyvault;

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

	private String connectionString = "default Value\n";

	public void run(String... varl) throws Exception {
		System.out.println(String.format("\nConnection String stored in Azure Key Vault:\n%s\n", connectionString));
	}
}

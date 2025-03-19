package com.clothshop.management;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Cloth Shop Management System API",
				version = "1.0",
				description = "\"This API manages products, customers, and suppliers in a cloth shop. \" +\n" +
						"                        \"It allows CRUD operations on all entities.\""
		)
)
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

}

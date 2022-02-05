package io.pragra.learning.pragravisit;

import com.bulsoft.DummyService;
import io.pragra.learning.pragravisit.entity.PragraVisitor;
import io.pragra.learning.pragravisit.service.VisitorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = {"com.bulsoft","io.pragra.learning.pragravisit"})
@SpringBootApplication
@EnableSwagger2

public class SpringjpaApplication {

	private VisitorService service;
	private DummyService dummyService;

	public SpringjpaApplication(VisitorService service, DummyService dummyService) {
		this.service = service;
		this.dummyService = dummyService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringjpaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
			dummyService.printSomeDetails();
		};
	}
}

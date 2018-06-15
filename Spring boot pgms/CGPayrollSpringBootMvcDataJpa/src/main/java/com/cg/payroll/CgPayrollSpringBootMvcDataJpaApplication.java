package com.cg.payroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@SpringBootApplication(scanBasePackages= {"com.cg"})
@EntityScan(basePackages="com.cg.beans")
@EnableJpaRepositories(basePackages="com.cg.daoservices")
@EnableWebMvc
public class CgPayrollSpringBootMvcDataJpaApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(CgPayrollSpringBootMvcDataJpaApplication.class, args);
	}
	@Override
	protected   SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CgPayrollSpringBootMvcDataJpaApplication.class);
	}
}

package com.jinzhimu.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jinzhimu.company.repository")
public class JzmCompanyApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JzmCompanyApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		setRegisterErrorPageFilter(false); // <- this one
        return application.sources(JzmCompanyApplication.class);
    }

}

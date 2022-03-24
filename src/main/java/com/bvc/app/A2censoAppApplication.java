package com.bvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
@EnableJpaRepositories(repositoryFactoryBeanClass=JpaRepositoryFactoryBean.class)

@SpringBootApplication
public class A2censoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(A2censoAppApplication.class, args);
	}

}

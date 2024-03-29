package app.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class ClienteCRUDApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteCRUDApplication.class, args);
	}

	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
    	LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
    	validatorFactoryBean.setValidationMessageSource(messageSource);
    	return validatorFactoryBean;
	}
}

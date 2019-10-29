package io.yeobi.cattoy;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CatToyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatToyApplication.class, args);
	}

	@Bean
	public Mapper modelMapper() {
		return DozerBeanMapperBuilder.buildDefault();
	}

}

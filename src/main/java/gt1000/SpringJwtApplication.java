package gt1000;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
//@EnableJpaAuditing
@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				log.info("####### cors filter 적용됨 #######");

				registry.addMapping("/**")
//						.allowCredentials(true)
						// allowedOrigins 보다 allowedOriginPatterns 권장 된다고 함
						.allowedOriginPatterns("*");
//						.allowedOrigins("*");
//						.allowedHeaders("*")
//						.allowedMethods("*");
			}
		};
	}
}

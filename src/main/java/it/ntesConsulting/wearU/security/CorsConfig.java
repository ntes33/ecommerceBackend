package it.ntesConsulting.wearU.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
       // commnication ports back and front
	   @Bean
	   public WebMvcConfigurer webMvcConfigurer() {
		
		return new WebMvcConfigurer() {
		
		@Override	
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")//allows resource sharing for all paths in the application.
			        .allowedMethods("GET","POST","PUT","DELETE")
			        .allowedOrigins("*");
		   }
			
		};
	
	}
	
}

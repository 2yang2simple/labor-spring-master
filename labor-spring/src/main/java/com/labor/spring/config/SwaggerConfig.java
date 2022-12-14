/******
 * //http://localhost:8080/auth/swagger-ui.html
 * @author evenyang
 *
 */
package com.labor.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2 
@Configuration
//@ConditionalOnProperty(name ="enabled" ,prefix = "swagger",havingValue = "true",matchIfMissing = true)
public class SwaggerConfig implements WebMvcConfigurer {
	
    
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
											.apiInfo(apiInfo()).select()
											.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
											.paths(PathSelectors.any())
											.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Labor-Spring")
				.description("OAuth, SSO, Accounts etc management")
//				.termsOfServiceUrl("http://47.106.74.136/auth")
				.version("1.0").build();
	}

}

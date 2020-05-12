package com.seyf.movie.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.seyf.movie"))
                .paths(PathSelectors.any())
                .build().pathMapping("/").apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        builder.title("Movie API through Swagger UI")
                .version("1.0")
                .description("List of all the APIs of Movie through Swagger UI ")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .contact(new Contact("Seyf", "seyf.com", "seyf@seyf.com"));

        return builder.build();
    }

}
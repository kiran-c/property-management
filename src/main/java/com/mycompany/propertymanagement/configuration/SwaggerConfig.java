package com.mycompany.propertymanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig implements WebMvcConfiguerer{

    @Bean
    public Docket appApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.mycompany.propertymanagement.controller"))
                .paths((PathSelectors.regex("/.*")))
                .build();

        return docket;
    }

}

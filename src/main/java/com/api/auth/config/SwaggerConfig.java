package com.api.auth.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiKey;

import java.util.Arrays;
import java.util.Collections;


@EnableSwagger2
@Configuration
@Api(value = "SBS - PDF", description = "Generator Pdf", tags = "PDF")
public class SwaggerConfig  {

    private ApiInfo apiInfo() {
        return new ApiInfo("Authentication Rest API for ME",
                "APIs for ME.",
                "1.0",
                "Api Autenticación Mercadeo Empresarial",
                new Contact("Nicolas", "", "nicolas.salazar@gracialab.com.co"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey(){
        return new ApiKey("JWT", "Authorization", "header");
    }
}

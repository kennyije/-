package com.lyw.config.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.TypeNameExtractor;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lengleng
 * @date 2017/12/28
 * swagger 配置
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String name;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).forCodeGeneration(true)
                .select().apis(RequestHandlerSelectors.basePackage("com.lyw.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(name)
                .description(name)
                .version("1.0")
                .build();
    }

    protected Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
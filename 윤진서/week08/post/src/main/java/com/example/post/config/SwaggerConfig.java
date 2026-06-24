package com.example.post.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger(OpenAPI) 문서 기본 정보 설정.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI postOpenAPI() {
        Info info = new Info()
                .title("게시글 관리 API")
                .description("8주차 과제 - CRUD REST API + Swagger 문서화")
                .version("v1.0.0");

        return new OpenAPI().info(info);
    }
}

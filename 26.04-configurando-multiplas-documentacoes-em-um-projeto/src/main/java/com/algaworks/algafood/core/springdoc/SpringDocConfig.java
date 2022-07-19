package com.algaworks.algafood.core.springdoc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AlgaFood API")
                        .version("v1")
                        .description("REST API do AlgaFood")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.com")
                        )
                ).externalDocs(new ExternalDocumentation()
                        .description("AlgaWorks")
                        .url("https://algaworks.com")
                );
    }

//    @Bean
//    public GroupedOpenApi groupedOpenApi() {
//        return GroupedOpenApi.builder()
//                .group("AlgaFood API Admin")
//                .pathsToMatch("/v1/**")
//                .addOpenApiCustomiser(openApi -> {
//                    openApi.info(new Info()
//                            .title("AlgaFood API Admin")
//                            .version("v1")
//                            .description("REST API do AlgaFood")
//                            .license(new License()
//                                    .name("Apache 2.0")
//                                    .url("http://springdoc.com")
//                            )
//                    ).externalDocs(new ExternalDocumentation()
//                            .description("AlgaWorks")
//                            .url("https://algaworks.com")
//                    );
//                })
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi groupedOpenApiCliente() {
//        return GroupedOpenApi.builder()
//                .group("AlgaFood API Cliente")
//                .pathsToMatch("/cliente/v1/**")
//                .addOpenApiCustomiser(openApi -> {
//                    openApi.info(new Info()
//                            .title("AlgaFood API Cliente")
//                            .version("v1")
//                            .description("REST API do AlgaFood")
//                            .license(new License()
//                                    .name("Apache 2.0")
//                                    .url("http://springdoc.com")
//                            )
//                    ).externalDocs(new ExternalDocumentation()
//                            .description("AlgaWorks")
//                            .url("https://algaworks.com")
//                    );
//                })
//                .build();
//    }

}

package com.acme.bet.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.ArrayList;
import java.util.List;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("bet")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        Server server = new Server();
        server.url("/");
        List<Server> servers = new ArrayList<>();
        servers.add(server);
        return new OpenAPI()
                .servers(servers)
                .info(new Info()
                        .title("Bet API")
                        .description("Bet OpenAPI Documentation")
                        .version("v1.0.0")
                        .license(new License().url("https://bet.app/license")))
                .externalDocs(new ExternalDocumentation()
                        .description("Bet Application")
                        .url("https://bet.app"));
    }
}

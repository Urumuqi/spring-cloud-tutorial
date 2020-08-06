package com.urumuqi.gatewayservice;

import com.urumuqi.gatewayservice.core.filters.DurationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

    @Bean
    public RouteLocator myLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/hello")
                        .uri("http://localhost:8903/hello")
                        .filters(new DurationFilter())
                        .id("order-srv")
                )
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

}

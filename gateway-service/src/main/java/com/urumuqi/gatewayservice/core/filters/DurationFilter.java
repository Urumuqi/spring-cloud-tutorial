package com.urumuqi.gatewayservice.core.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wuqi
 * @desc 自定义网关过滤器，计算请求完成时间.
 * @class DurationFilter
 * @date 2020/8/3 17:34
 **/
public class DurationFilter implements GatewayFilter, Ordered {

    private static final String ELAPSED_TIME_BEGIN = "elapsedTimeBegin";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(ELAPSED_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange)
                .then(
                        Mono.fromRunnable(() -> {
                            Long startTime = exchange.getAttribute(ELAPSED_TIME_BEGIN);
                            if (startTime != null) {
                                System.out.println(exchange.getRequest().getURI().getRawPath() + " : " + (System.currentTimeMillis() - startTime) + " ms");
                            }
                        })
                );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}

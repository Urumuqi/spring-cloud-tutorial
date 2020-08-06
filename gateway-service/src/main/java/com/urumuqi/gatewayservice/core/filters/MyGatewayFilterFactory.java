package com.urumuqi.gatewayservice.core.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author wuqi
 * @desc 自定义 Gateway Filter Factory.
 * @class MyGatewayFilterFactory
 * @date 2020/8/4 09:07
 **/
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(MyGatewayFilterFactory.class);

    public MyGatewayFilterFactory() {
        super(Config.class);
        log.info("initialize MyGatewayFilterFactory");
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.info("step in MyGatewayFilterFactory apply func");
        return (exchange, chain) -> {
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private boolean enabled;

        public Config() {
            // new instance
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}

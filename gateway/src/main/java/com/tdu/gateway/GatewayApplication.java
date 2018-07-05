package com.tdu.gateway;

import com.tdu.gateway.filter.AuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {
    private static final String ALL = "*";
    private static final String MAX_AGE = "18000L";



    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
				.route(r -> r.path("/api/s_hello")
						.uri("http://localhost:9092/s_hello")
				).build();
	}

//    @Bean
//    public ErrorWebExceptionHandler myExceptionHandler() {
//        return new MyWebExceptionHandler();
//    }
//
//    public class MyWebExceptionHandler implements ErrorWebExceptionHandler {
//        @Override
//        public Mono<Void> handle(
//                ServerWebExchange exchange, Throwable ex) {
//            ServerHttpResponse serverHttpResponse = exchange.getResponse();
//            serverHttpResponse.contentType(MediaType.APPLICATION_JSON_UTF8)
//            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
//            byte[] bytes = "{\"status\":\"-1\",\"msg\":\"权限不足\"}".getBytes(StandardCharsets.UTF_8);
//            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
//            return exchange.getResponse().writeWith(Flux.just(buffer));
//        }
//    }

    @Bean
    public AuthorizationFilter accessFilter() {
        return new AuthorizationFilter();
    }

    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (!CorsUtils.isCorsRequest(request)) {
                return chain.filter(ctx);
            }
            HttpHeaders        requestHeaders = request.getHeaders();
            ServerHttpResponse response       = ctx.getResponse();
            HttpMethod         requestMethod  = requestHeaders.getAccessControlRequestMethod();
            HttpHeaders        headers        = response.getHeaders();
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
            headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
            if (requestMethod != null) {
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
            }
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, ALL);
            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
            if (request.getMethod() == HttpMethod.OPTIONS) {
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }
            return chain.filter(ctx);
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}

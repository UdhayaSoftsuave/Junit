package com.example.JuintTesting.annotation;

import com.example.JuintTesting.Entity.EmployeeHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.http.codec.DecoderHttpMessageReader;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.annotation.AbstractMessageReaderArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
@Slf4j
public class CustomAnnotationResolver extends AbstractMessageReaderArgumentResolver {
    public CustomAnnotationResolver(Jackson2JsonDecoder decoder) {
        super(Collections.singletonList(new DecoderHttpMessageReader<>(decoder)));
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameter().isAnnotationPresent(CustomAnnotation.class);
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter parameter, BindingContext bindingContext, ServerWebExchange exchange) {
        log.info("Stting the header the request");
            return readBody(parameter,true,bindingContext,exchange)
                    .map(deserialized -> {
                        if (deserialized instanceof EmployeeHeader){
                           if (exchange.getRequest().getHeaders().containsKey("employeeId")){
                               String employeeId = exchange.getRequest().getHeaders().get("employeeId").get(0);
                               try {
                                   employeeId = URLDecoder.decode(employeeId, "UTF-8");
                               } catch (UnsupportedEncodingException e) {
                                   throw new RuntimeException(e);
                               }
                               ((EmployeeHeader) deserialized).setEmployeeId(Integer.parseInt(employeeId));
                           }

                        }
                        return deserialized;
                    });
    }
}

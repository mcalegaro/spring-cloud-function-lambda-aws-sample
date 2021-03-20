package com.example.springcloudfunctiontest.functions;

import java.util.function.Function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Proxy implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private static final String PATH1 = "/{path1}";
    private static final String PATH2 = "/{path1}/{path2}";
    private static final Gson g = new Gson();

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent requestEvent) {
        log.info("{}", g.toJson(requestEvent));
        switch (requestEvent.getResource()) {
        case PATH2:
            log.info("PATH1");
            break;
        case PATH1:
        default:
            log.info("PATH2");
            break;
        }
        log.info("Method: {}", requestEvent.getHttpMethod());
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setBody(g.toJson(requestEvent.getBody()));
        response.setStatusCode(200);
        return response;
    }

}
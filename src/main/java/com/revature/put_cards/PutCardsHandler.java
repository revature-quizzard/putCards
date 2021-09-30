package com.revature.put_cards;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PutCardsHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();
    private final CardRepo cardRepo = new CardRepo();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context){

        LambdaLogger logger = context.getLogger();

        logger.log("Received event: " + requestEvent);

        String id = requestEvent.getQueryStringParameters().get("id");




        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        System.out.println("Updating a card");

        return responseEvent;
    }
}

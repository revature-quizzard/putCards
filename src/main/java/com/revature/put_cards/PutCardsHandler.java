package com.revature.put_cards;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.dto.CardDto;



/**
 * The PutCardsHandler class is an AWS Lambda function to handle update operations on Card objects.
 * This function occupies the PUT Request Method on the Card endpoint.
 */


public class PutCardsHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final Gson mapper = new GsonBuilder().setPrettyPrinting().create();
    private final SetRepo setRepo;

    public PutCardsHandler(){
        this.setRepo = new SetRepo();
    }

    public PutCardsHandler(SetRepo setRepo){
        this.setRepo = new SetRepo();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context){

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

        LambdaLogger logger = context.getLogger();
        logger.log("Received event: " + requestEvent);

        CardDto cardDto = null;
        Set set = null;

        String setId = requestEvent.getQueryStringParameters().get("set_id");

        String cardId = requestEvent.getQueryStringParameters().get("card_id");

        try {
            cardDto = mapper.fromJson(requestEvent.getBody(), CardDto.class);
        }catch (Exception e){
            responseEvent.setStatusCode(400);
            return responseEvent;
        }

        set = setRepo.getSet(setId);

        Card result = null;
        for (Card c: set.getCards()){
            if(c.getId().equals(cardId)){
                result = c;
                c.setQuestion(cardDto.getQuestion());
                c.setAnswer(cardDto.getAnswer());
            }
        }

        setRepo.updateSet(set);
        responseEvent.setBody(result.toString());
        return responseEvent;
    }
}

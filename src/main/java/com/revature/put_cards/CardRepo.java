package com.revature.put_cards;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class CardRepo {

    private final DynamoDBMapper dbReader;

    public CardRepo() { dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient()); }

    public void updateCardById(String id){

        Card updateCard = new Card();
        dbReader.save(updateCard);

    }

}

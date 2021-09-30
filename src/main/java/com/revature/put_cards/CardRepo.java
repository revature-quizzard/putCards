package com.revature.put_cards;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class CardRepo {

    private final DynamoDBMapper dbReader;

    public CardRepo() { dbReader = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient()); }

    public void deleteCardById(String id){

        Card deleteCard = new Card();
        deleteCard.setId(id);
        dbReader.delete(deleteCard);

    }

}

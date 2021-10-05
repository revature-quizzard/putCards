package com.revature.put_cards;


import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;



/**
 * The Card class is a POJO representing the Card model.
 */

@Data
@DynamoDbBean
public class Card {

    private String id;
    private String setId;
    private String question;
    private String answer;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("setId")
    public String getSetId() {
        return setId;
    }

    @DynamoDbAttribute("question")
    public String getQuestion() {
        return question;
    }

    @DynamoDbAttribute("answer")
    public String getAnswer() {
        return answer;
    }
}

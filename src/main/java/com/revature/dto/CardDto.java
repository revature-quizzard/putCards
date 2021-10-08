package com.revature.dto;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

/**
 * The CardDto class is a DTO which contains the fields within the Card model which can be updated.
 */

@Data
@DynamoDbBean
public class CardDto {

    private String question;
    private String answer;


    @DynamoDbAttribute("question")
    public String getQuestion() {
        return question;
    }

    @DynamoDbAttribute("answer")
    public String getAnswer() {
        return answer;
    }
}

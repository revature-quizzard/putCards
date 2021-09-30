package com.revature.put_cards;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@DynamoDbBean
public class Tag {

    private String tagName;
    private String tagColor;


    @DynamoDbPartitionKey
    public String getTagName() {
        return tagName;
    }

    @DynamoDbAttribute("tagColor")
    public String getTagColor() {
        return tagColor;
    }


    public Tag(String tagName){
        this.tagName = tagName;
    }

    public Tag() {
        super();
    }

}

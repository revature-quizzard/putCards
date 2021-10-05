package com.revature.put_cards;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


/**
 * The Tag class is a POJO representing the Tag model.
 */

@Data
@DynamoDbBean
public class Tag {

    private String tagName;
    private String tagColor;


    @DynamoDbPartitionKey
    public String getName() {
        return tagName;
    }

    @DynamoDbAttribute("color")
    public String getColor() {
        return tagColor;
    }


    public Tag(String tagName){
        this.tagName = tagName;
    }

    public Tag() {
        super();
    }

}

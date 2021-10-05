package com.revature.put_cards;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


/**
 * The SetRepo class is a database repository which provides CRUD operations on the Sets table.
 */


public class SetRepo {

    private final DynamoDbTable<Set> setTable;

    public SetRepo(){
        DynamoDbClient db = DynamoDbClient.builder().httpClient(ApacheHttpClient.create()).build();
        DynamoDbEnhancedClient client = DynamoDbEnhancedClient.builder().dynamoDbClient(db).build();
        setTable = client.table("Sets", TableSchema.fromBean(Set.class));
    }

    public Set updateSet(Set updatedSet){
        setTable.updateItem(updatedSet);
        return updatedSet;
    }

    public Set getSet(String id){
        Key key = Key.builder().partitionValue(id).build();
        return setTable.getItem(key);
    }
}

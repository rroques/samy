package nz.co.rroques.samy;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.local.embedded.DynamoDBEmbedded;
import com.amazonaws.services.dynamodbv2.local.shared.access.AmazonDynamoDBLocal;
import com.amazonaws.services.dynamodbv2.model.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HandlerTest {

    private static AmazonDynamoDBLocal amazonDynamoDBLocal;
    private AmazonDynamoDB amazonDynamoDB;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("java.library.path", "/Users/remiroques/Developer/samy/build/libs/");
        amazonDynamoDBLocal = DynamoDBEmbedded.create();
    }

    @BeforeEach
    public void before() {
        amazonDynamoDB = amazonDynamoDBLocal.amazonDynamoDB();
    }

    @AfterAll
    public static void afterAll() {
        amazonDynamoDBLocal.shutdown();
    }

    @Test
    public void test() {
        CreateTableRequest createTableRequest = new CreateTableRequest("TestTable",
                Arrays.asList(
                    new KeySchemaElement("id", KeyType.HASH)
                )
        );
        createTableRequest.setAttributeDefinitions(
                Arrays.asList(
                        new AttributeDefinition("id", ScalarAttributeType.S)
                )
        );
        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1l, 1l));
        amazonDynamoDB.createTable(createTableRequest);


        amazonDynamoDB.putItem(new PutItemRequest("TestTable", ImmutableMap.of("id", new AttributeValue("123"))));
    }
}

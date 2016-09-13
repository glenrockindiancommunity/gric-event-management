package org.glenrockindiancommunity;

import java.util.ArrayList;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { DynamoDBConfig.class })
@TestPropertySource("classpath:/config.properties")
public class DiwaliRegistrationTest {

  private static final String KEY_NAME = "id";
  private static final Long READ_CAPACITY_UNITS = 5L;
  private static final Long WRITE_CAPACITY_UNITS = 5L;
  private static final String TABLE_NAME = "Family";

  @Autowired
  private FamilyRepository repository;

  @Autowired
  private AmazonDynamoDB dynamodb;

  @Before
  public void init() throws Exception {

    ListTablesResult listTablesResult = dynamodb.listTables();

    listTablesResult.getTableNames().stream().filter(tableName -> tableName.equals(TABLE_NAME)).forEach(tableName -> {
      dynamodb.deleteTable(tableName);
    });

    List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
    attributeDefinitions.add(new AttributeDefinition().withAttributeName(KEY_NAME).withAttributeType("S"));

    List<KeySchemaElement> keySchemaElements = new ArrayList<KeySchemaElement>();
    keySchemaElements.add(new KeySchemaElement().withAttributeName(KEY_NAME).withKeyType(KeyType.HASH));

    CreateTableRequest request = new CreateTableRequest().withTableName(TABLE_NAME).withKeySchema(keySchemaElements)
        .withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(new ProvisionedThroughput()
            .withReadCapacityUnits(READ_CAPACITY_UNITS).withWriteCapacityUnits(WRITE_CAPACITY_UNITS));

    dynamodb.createTable(request);

  }

  @Test
  public void registerFamilyTest() {
    Family family = new Family("Lastname", "firstname", "GR", 2, 2, "test@example.com", true, true);
    String familyNameCode = family.getFamilyNameCode();
    repository.save(family);

    Family family2 = new Family("Lastname_2", "firstname_2", "GR", 4, 0, "test@example.com", true, false);
    repository.save(family2);

    Family family3 = repository.findByFamilyNameCode(familyNameCode);

    Assert.assertEquals(family3, family);
  }

}

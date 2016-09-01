package org.glenrockindiancommunity;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "org.glenrockindiancommunity")
@PropertySource("classpath:/aws-config.properties")
public class DynamoDBConfig {
    
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentials amazonAWSCredentials) {
	AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials);

	if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
	    amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
	}
	return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
	// Or use an AWSCredentialsProvider/AWSCredentialsProviderChain
	return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
    
    @Bean
    static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer () {
	return new PropertySourcesPlaceholderConfigurer ();
    }

}

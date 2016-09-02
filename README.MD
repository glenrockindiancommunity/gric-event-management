[![Build Status](https://travis-ci.org/varunmehta/gric-diwali.svg?branch=master)](https://travis-ci.org/varunmehta/gric-diwali)

# Glen Rock Indian Community - Diwali Registration

Basic spring-boot app, which persists data to DynamoDB and integrates with Stripe for capturing payment info.

## Pre-requisite
You need to download and run DynamoDB locally and set the endpoint to http://localhost:8000

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html#DynamoDBLocal.DownloadingAndRunning

## Travis is failing, as the test needs a local instance of DynamoDB running. Tried setting up DynamoDBEmbedded, but it needs sqllite in classpath, so does not exactly help for Travis. 
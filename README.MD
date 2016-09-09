[![Build Status](https://travis-ci.org/varunmehta/gric-diwali.svg?branch=master)](https://travis-ci.org/varunmehta/gric-diwali)

# Glen Rock Indian Community - Diwali Registration
Basic spring-boot app, which persists data to DynamoDB and integrates with Stripe for capturing payment info. This will be deployed on either AWS or Heroku, depending upon what does the pricing allow finally!

# Registration Flow

## Step 1:
![Registration Step 1:]
(https://raw.githubusercontent.com/varunmehta/gric-diwali/master/docs/Registration%20Step%201_%20Inital%20Setup.png)


## Step 2:
![Registration Step 2:]
(https://raw.githubusercontent.com/varunmehta/gric-diwali/master/docs/Registration%20Step%202_%20Family%20information.png)


## Step 3:
![Registration Step 3:]
(https://raw.githubusercontent.com/varunmehta/gric-diwali/master/docs/Registration%20Step%203_%20Payment.png)

## Step 4:
![Registration Step 4:]
(https://raw.githubusercontent.com/varunmehta/gric-diwali/master/docs/Registration%20Step%204_%20Confirmation!.png)


# Contributing.
Clone the project off git. 

``` mvn clean install ```

Import into your IDE. You need to download and run DynamoDB locally and set the endpoint to http://localhost:8000

http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.html#DynamoDBLocal.DownloadingAndRunning

**Travis was failing, as the test needs a local instance of DynamoDB running. Tried setting up DynamoDBEmbedded, but it needs sqllite in classpath, so does not exactly help for Travis.** 
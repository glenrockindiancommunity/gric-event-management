[![Build Status](https://travis-ci.org/glen-rock-indian-community/gric-event-management.svg?branch=master)](https://travis-ci.org/glen-rock-indian-community/gric-event-management)

# Glen Rock Indian Community - Event Registration
The Glen Rock Indian Community hosts a series of events per year. Managing user registration and payments becomes a big ordeal. In order to save the run around, we use this app to manage the whole process.

## Learning
If you are interested to learn Stripe integration with spring-boot, you can use this app.

# Contributing.
Message https://github.com/varunmehta to get added to the GRIC organizer as a contributor.

# Deploying locally

``` mvn clean install ```

# Create an event

POST to ```/event```

Use the json

```{
  "name" : "GRIC Diwali 2016",
  "startDateTime" : "2017-09-28T18:00:00Z",
  "endDateTime" : "2017-09-28T23:00:00Z",
  "location" : "190 US-46, Saddle Brook, NJ 07663",
  "adultCost" : "100.00",
  "childCost" : "50.00",
  "free" : false
  }```

Import into your IDE, and work!
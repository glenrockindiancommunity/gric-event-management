package org.glenrockindiancommunity.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class FamilyMember {

    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private Boolean participant;

    FamilyMember() {
	// default constructor
    }

    public FamilyMember(String firstName, String lastName, String gender, Integer age, Boolean participant) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.age = age;
	this.participant = participant;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public String getGender() {
	return gender;
    }

    public Integer getAge() {
	return age;
    }

    public Boolean getParticipant() {
	return participant;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public void setParticipant(Boolean participant) {
	this.participant = participant;
    }

}

package org.glenrockindiancommunity.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class FamilyMember {

	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Integer age;
	private Boolean primaryEmail;
	private Boolean subscribeEmail;
	private Boolean participant;
	private Boolean volunteer;

	public FamilyMember() {
		// default constructor for testing, need better solution.
	}

	public FamilyMember(String firstName, String lastName, String email, String gender, Integer age,
			Boolean primaryEmail, Boolean subscribeEmail, Boolean participant, Boolean volunteer) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.age = age;
		this.primaryEmail = primaryEmail;
		this.subscribeEmail = subscribeEmail;
		this.participant = participant;
		this.volunteer = volunteer;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public Integer getAge() {
		return age;
	}

	public Boolean isPrimaryEmail() {
		return primaryEmail;
	}

	public Boolean isSubscribeEmail() {
		return subscribeEmail;
	}

	public Boolean isParticipant() {
		return participant;
	}

	public Boolean isVolunteer() {
		return volunteer;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setPrimaryEmail(Boolean primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public void setSubscribeEmail(Boolean subscribeEmail) {
		this.subscribeEmail = subscribeEmail;
	}

	public void setParticipant(Boolean participant) {
		this.participant = participant;
	}

	public void setVolunteer(Boolean volunteer) {
		this.volunteer = volunteer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((participant == null) ? 0 : participant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamilyMember other = (FamilyMember) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FamilyMember [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", age=" + age
				+ ", participant=" + participant + "]";
	}

}

package org.glenrockindiancommunity.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Family")
public class Family {

  private String id;
  private String familyNameCode;
  private String town;
  private Integer adults;
  private Integer children;
  private BigDecimal amount;
  private String primaryEmail;
  private String stripeReceiptNumber;
  @DynamoDBAttribute(attributeName = "FamilyMembers")
  private List<FamilyMember> familyMembers = new ArrayList<FamilyMember>();;

  public Family() {
    // default constructor
  }

  public Family(String familyNameCode, String town, Integer adults, Integer children, BigDecimal amount) {
    this.familyNameCode = familyNameCode + UUID.randomUUID().toString().replaceAll("-", "");
    this.town = town;
    this.adults = adults;
    this.children = children;
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public String getFamilyNameCode() {
    return familyNameCode;
  }

  public String getTown() {
    return town;
  }

  public Integer getAdults() {
    return adults;
  }

  public Integer getChildren() {
    return children;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public String getPrimaryEmail() {
    return primaryEmail;
  }

  public String getStripeReceiptNumber() {
    return stripeReceiptNumber;
  }

  public List<FamilyMember> getFamilyMembers() {
    return familyMembers;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setFamilyNameCode(String familyNameCode) {
    this.familyNameCode = familyNameCode;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public void setAdults(Integer adults) {
    this.adults = adults;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setPrimaryEmail(String primaryEmail) {
    this.primaryEmail = primaryEmail;
  }

  public void setStripeReceiptNumber(String stripeReceiptNumber) {
    this.stripeReceiptNumber = stripeReceiptNumber;
  }

  public void setFamilyMembers(List<FamilyMember> familyMembers) {
    this.familyMembers = familyMembers;
  }
  
  public void addFamilyMember(FamilyMember familyMember) {
    this.familyMembers.add(familyMember);
  }
  
  public void addFamilyMembers(List<FamilyMember> familyMembers) {
    this.familyMembers.addAll(familyMembers);
  }
  

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((adults == null) ? 0 : adults.hashCode());
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((children == null) ? 0 : children.hashCode());
    result = prime * result + ((familyNameCode == null) ? 0 : familyNameCode.hashCode());
    result = prime * result + ((primaryEmail == null) ? 0 : primaryEmail.hashCode());
    result = prime * result + ((stripeReceiptNumber == null) ? 0 : stripeReceiptNumber.hashCode());
    result = prime * result + ((town == null) ? 0 : town.hashCode());
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
    Family other = (Family) obj;
    if (adults == null) {
      if (other.adults != null)
        return false;
    } else if (!adults.equals(other.adults))
      return false;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (children == null) {
      if (other.children != null)
        return false;
    } else if (!children.equals(other.children))
      return false;
    if (familyNameCode == null) {
      if (other.familyNameCode != null)
        return false;
    } else if (!familyNameCode.equals(other.familyNameCode))
      return false;
    if (primaryEmail == null) {
      if (other.primaryEmail != null)
        return false;
    } else if (!primaryEmail.equals(other.primaryEmail))
      return false;
    if (stripeReceiptNumber == null) {
      if (other.stripeReceiptNumber != null)
        return false;
    } else if (!stripeReceiptNumber.equals(other.stripeReceiptNumber))
      return false;
    if (town == null) {
      if (other.town != null)
        return false;
    } else if (!town.equals(other.town))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Family [id=" + id + ", familyNameCode=" + familyNameCode + ", town=" + town + ", adults=" + adults
        + ", children=" + children + ", amount=" + amount + ", primaryEmail=" + primaryEmail + ", stripeReceiptNumber="
        + stripeReceiptNumber + ", familyMembers=" + familyMembers + "]";
  }

}

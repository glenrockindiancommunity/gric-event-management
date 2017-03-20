package org.glenrockindiancommunity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author vmehta
 *
 */
@Entity
public class GricEvent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String name;
  private String description;
  private String startDate;
  private String startTime;
  private String endDate;
  private String endTime;
  private Integer maxCapacity = 0;
  private String location;
  private String locationURL;
  private String flyerUrl;
  private String contactEmail;

  // Event Charges
  private BigDecimal adultCost;
  private BigDecimal childCost;

  // Offload Stripe transactionFee to end user
  private Boolean offLoadTransactionFee = false;

  // if an event is free!
  private Boolean free;

  // Audit Info
  private String createdBy;
  private Date createdDate = new Date();
  private String updatedBy;
  private Date updatedDate = new Date();

  private Boolean pinned;

  /**
   * Minimum information required to create an event.
   * 
   * @param name
   * @param description
   * @param location
   * @param startDate
   * @param startTime
   * @param endDate
   * @param endTime
   * @param contactEmail
   */
  public GricEvent(String name, String description, String location, String startDate, String startTime, String endDate,
      String endTime, String contactEmail) {
    this.name = name;
    this.description = description;
    this.location = location;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
    this.contactEmail = contactEmail;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getStartDate() {
    return startDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getEndDate() {
    return endDate;
  }

  public String getEndTime() {
    return endTime;
  }

  public Integer getMaxCapacity() {
    return maxCapacity;
  }

  public String getLocation() {
    return location;
  }

  public String getLocationURL() {
    return locationURL;
  }

  public String getFlyerUrl() {
    return flyerUrl;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public BigDecimal getAdultCost() {
    return adultCost;
  }

  public BigDecimal getChildCost() {
    return childCost;
  }

  public Boolean getOffLoadTransactionFee() {
    return offLoadTransactionFee;
  }

  public Boolean getFree() {
    return free;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public Boolean getPinned() {
    return pinned;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public void setMaxCapacity(Integer maxCapacity) {
    this.maxCapacity = maxCapacity;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setLocationURL(String locationURL) {
    this.locationURL = locationURL;
  }

  public void setFlyerUrl(String flyerUrl) {
    this.flyerUrl = flyerUrl;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public void setAdultCost(BigDecimal adultCost) {
    this.adultCost = adultCost;
  }

  public void setChildCost(BigDecimal childCost) {
    this.childCost = childCost;
  }

  public void setOffLoadTransactionFee(Boolean offLoadTransactionFee) {
    this.offLoadTransactionFee = offLoadTransactionFee;
  }

  public void setFree(Boolean free) {
    this.free = free;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public void setPinned(Boolean pinned) {
    this.pinned = pinned;
  }

}

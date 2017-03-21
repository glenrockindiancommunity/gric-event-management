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
  private BigDecimal adultCost = new BigDecimal("0.0");
  private BigDecimal childCost = new BigDecimal("0.0");

  // Off load the ~3% Stripe transactionFee to end user
  private boolean transactionFeeCharged = false;

  // if an event is free!
  private boolean free = false;

  // Audit Info
  private String createdBy;
  private Date createdDate = new Date();
  private String updatedBy;
  private Date updatedDate = new Date();

  // Show on home page.
  private boolean pinned = false;

  /**
   * Minimum data needed to create an event.
   * 
   * @param name
   * @param startDate
   * @param startTime
   * @param endDate
   * @param endTime
   * @param location
   * @param adultCost
   * @param childCost
   * @param free
   */
  public GricEvent(String name, String startDate, String startTime, String endDate, String endTime, String location,
      BigDecimal adultCost, BigDecimal childCost, boolean free) {
    this.name = name;
    this.startDate = startDate;
    this.startTime = startTime;
    this.endDate = endDate;
    this.endTime = endTime;
    this.location = location;
    this.adultCost = adultCost;
    this.childCost = childCost;
    this.free = free;
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

  public boolean isTransactionFeeCharged() {
    return transactionFeeCharged;
  }

  public boolean isFree() {
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

  public boolean isPinned() {
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

  public void setTransactionFeeCharged(boolean transactionFeeCharged) {
    this.transactionFeeCharged = transactionFeeCharged;
  }

  public void setFree(boolean free) {
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

  public void setPinned(boolean pinned) {
    this.pinned = pinned;
  }

}

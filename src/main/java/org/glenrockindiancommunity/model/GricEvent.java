package org.glenrockindiancommunity.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
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
  private Integer id;
  private String name;
  private String description;
  private LocalDateTime startDateTime;
  private LocalDateTime endDateTime;
  private Integer maxCapacity = 0;
  private String location;
  @Column(length = 1024)
  private String locationURL;
  private String flyerUrl;
  private String contactEmail;

  // Event Charges
  private BigDecimal adultCost = new BigDecimal("0.0");
  private BigDecimal childCost = new BigDecimal("0.0");

  // Off load the ~3% Stripe transactionFee to end user
  private boolean transactionFeeCharged = false;

  private String paymentLogo;

  // if an event is free!
  private boolean free = false;

  // Audit Info
  private String createdBy;
  private Date createdDate = new Date();
  private String updatedBy;
  private Date updatedDate = new Date();

  // Show on home page.
  private boolean pinned = false;

  private GricEvent() {
    // hibernate or jackson wants it
  }

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
  public GricEvent(String name, LocalDateTime startDate, LocalDateTime endDate, String location, BigDecimal adultCost,
      BigDecimal childCost, boolean free) {
    this.name = name;
    this.startDateTime = startDate;
    this.endDateTime = endDate;
    this.location = location;
    this.adultCost = adultCost;
    this.childCost = childCost;
    this.free = free;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getStartDateTime() {
    return startDateTime;
  }

  public LocalDateTime getEndDateTime() {
    return endDateTime;
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

  public String getPaymentLogo() {
    return paymentLogo;
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

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStartDateTime(LocalDateTime startDateTime) {
    this.startDateTime = startDateTime;
  }

  public void setEndDateTime(LocalDateTime endDateTime) {
    this.endDateTime = endDateTime;
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

  public void setPaymentLogo(String paymentLogo) {
    this.paymentLogo = paymentLogo;
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

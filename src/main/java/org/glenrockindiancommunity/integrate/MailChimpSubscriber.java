package org.glenrockindiancommunity.integrate;

public class MailChimpSubscriber {

  private MergeFields mergeFields;
  private String emailAddress;
  private String status = "subscribed";

  public MailChimpSubscriber(String fname, String lname, String emailAddress) {
    this.mergeFields = new MergeFields(fname, lname);
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getStatus() {
    return status;
  }

  public String getLname() {
    return mergeFields.getLname();
  }

  public String getFname() {
    return mergeFields.getFname();
  }

  private class MergeFields {
    private String fname;
    private String lname;

    public MergeFields(String fname, String lname) {
      this.fname = fname;
      this.lname = lname;
    }

    public String getFname() {
      return fname;
    }

    public String getLname() {
      return lname;
    }

    @Override
    public String toString() {
      return "MergeFields [fname=" + fname + ", lname=" + lname + "]";
    }

  }

  @Override
  public String toString() {
    return "MailChimpSubscriber [mergeFields=" + mergeFields.toString() + ", emailAddress=" + emailAddress + ", status="
        + status + "]";
  }

}

package org.glenrockindiancommunity.integrate;

public class MailChimpSubscriber {

  private MergeFields merge_fields;
  private String emailAddress;
  private String status = "subscribed";

  public MailChimpSubscriber(String fname, String lname, String emailAddress) {
    this.merge_fields = new MergeFields(fname, lname);
    this.emailAddress = emailAddress;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getStatus() {
    return status;
  }

  public String getLname() {
    return merge_fields.getLNAME();
  }

  public String getFname() {
    return merge_fields.getFNAME();
  }

  private class MergeFields {
    private String FNAME;
    private String LNAME;

    public MergeFields(String fNAME, String lNAME) {
      FNAME = fNAME;
      LNAME = lNAME;
    }

    public String getFNAME() {
      return FNAME;
    }

    public String getLNAME() {
      return LNAME;
    }

    @Override
    public String toString() {
      return "MergeFields [FNAME=" + FNAME + ", LNAME=" + LNAME + "]";
    }

  }

  @Override
  public String toString() {
    return "MailChimpSubscriber [mergeFields=" + merge_fields.toString() + ", emailAddress=" + emailAddress
        + ", status=" + status + "]";
  }

}

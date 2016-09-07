package org.glenrockindiancommunity.integrate;

public class MailChimpSubscriber {

	MergeFields mergeFields;
	String emailAddress;
	String status = "subscribed";

	public MailChimpSubscriber(String fname, String lname, String emailAddress) {
		this.mergeFields = new MergeFields(fname, lname);
		this.emailAddress = emailAddress;
	}

	class MergeFields {
		String fname;
		String lname;

		public MergeFields(String fname, String lname) {
			this.fname = fname;
			this.lname = lname;
		}
	}
}

<html>
<head>
<title>Glen Rock Indian Community - Registration</title>

<!-- Include CSS -->
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">

<!-- Include JS -->
<script src="https://checkout.stripe.com/checkout.js"></script>

<script type="text/javascript" src="static/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="static/js/jquery-dateFormat.min.js"></script>
<script type="text/javascript" src="static/js/jquery.smartWizard.js"></script>
<script type="text/javascript" src="static/js/registration.js"></script>

<script type="text/javascript">
		function populateEventDetails() {
		    var eventId = $("eventId").val();
		    var url = "/event/" + <%=request.getParameter("id")%>;
		    $.get(url, function(data, status) {
		      var html = ""
		      var event = data;
		      $('#eventName').text(event.name);
		      $('#eventNameAgain').text(event.name);
		      $('#eventAddress').text(event.location);
		      $('#eventAddressAgain').text(event.location);
	        $('#eventDescription').text(event.description);
	        $('#eventFlyer').append('<a href="' + event.flyerUrl + '">' + event.flyerUrl + '</a>');
	        $('#eventMap').attr('src', event.locationURL);
	        $('#eventContactEmail').append('<a href="mailto:' + event.contactEmail + '">' + event.contactEmail + '</a>');
	        $('#eventContactEmailAgain').append('<a href="mailto:' + event.contactEmail + '">' + event.contactEmail + '</a>');
		      
		      var dateTime = $.format.date(event.startDateTime, "hh:mm a") + " - " + $.format.date(event.endDateTime, "hh:mm a") + ",<br />" + $.format.date(event.endDateTime, "ddd, MMMM dd, yyyy") 
		      $('#eventPricing').text("Adults: $" + event.adultCost + " - Kids: $" + event.childCost);
		      $('#eventTime').append(dateTime);
		      $('#eventTimeAgain').append(dateTime);
		      $('#eventImage').val(event.paymentLogo);
		});
	}
</script>
</head>
<body>
  <h1>
    Glen Rock Indian Community <span id="eventName"></span> Registration
  </h1>
  <form action="#" method="POST" id="mainForm">
    <input type='hidden' name="issubmit" value="1"> 
    <input type='hidden' name="eventId" id="eventId" value='<%=request.getParameter("id")%>'>
    <input type='hidden' name="eventImage" id="eventImage" value=''>
    <!-- Tabs -->
    <div id="wizard" class="swMain">
      <ul>
        <li><a href="#step-1"> <span class="stepNumber">1</span> <span class="stepDesc"> Welcome<br /> <small>Event
                Details</small>
          </span>
        </a></li>
        <li><a href="#step-2"> <span class="stepNumber">2</span> <span class="stepDesc"> Participant Details<br />
              <small>Provide details as asked for</small>
          </span>
        </a></li>
        <li><a href="#step-3"> <span class="stepNumber">3</span> <span class="stepDesc"> Payment<br /> <small>Pay
                for the event</small>
          </span>
        </a></li>
        <li><a href="#step-4"> <span class="stepNumber">4</span> <span class="stepDesc"> Ticket<br /> <small>Print
                tickets</small>
          </span>
        </a></li>
      </ul>
      <div id="step-1">
        <h2 class="StepTitle">Step 1: Welcome</h2>
        <table>
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="3" align="left">
              <h2 align="center" id="eventNameAgain">&nbsp;</h2>

              <div id="eventDescription">&nbsp;</div>

              <h2 align="center" id="eventTime">
                &nbsp;
              </h2>

              <h3 align="center" id="eventFlyer">&nbsp;</h3>
            </td>
          </tr>
          <tr>
            <td colspan="3" align="left">&nbsp;</td>
          </tr>
          <tr>
            <td align="left" colspan="3">
              <p align="center">
                <iframe name="eventMap" id="eventMap"
                  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3016.20469942012!2d-74.099133584143!3d40.88932443468427!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2f96256082115%3A0x3b90c1b864be0f25!2sThe+Excelsior+Catering!5e0!3m2!1sen!2sus!4v1473460458353"
                  width="600" height="450" frameborder="0" style="border: 0" allowfullscreen></iframe>
              </p>
              <h2 align="center" id="eventAddress">&nbsp;
              </h2>
              <h3 align="center" id="eventContactEmail">&nbsp;</h3>
            </td>
          </tr>
        </table>
      </div>
      <div id="step-2">
        <h2 class="StepTitle">Step 2: Family Details</h2>
        <table cellpadding="3" cellspacing="3">
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="3" align="left">
              <h3>Please note</h3>
              <ol>
                <li>For volunteering OR if interested to perform, please update the form accordingly, and someone will
                  get in touch with you ASAP</li>
              </ol>

              <h2 align="center" id="eventPricing">&nbsp;</h2>

              <h2 class="StepTitle">Fill the form</h2>
            </td>
          </tr>
          <tr>
            <td align="right">Last Name<span class="required">*</span> :
            </td>
            <td align="left"><input type="text" id="lastname" name="lastname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_lastname"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">First Name<span class="required">*</span> :
            </td>
            <td align="left"><input type="text" id="firstname" name="firstname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_firstname"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Primary Email<span class="required">*</span> :
            </td>
            <td align="left"><input type="text" id="primaryEmail" name="primaryEmail" value="" class="txtBox"></td>
            <td align="left"><span id="msg_primaryEmail"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Town<span class="required">*</span> :
            </td>
            <td align="left"><select id="town" name="town" class="txtBox">
                <option value="">-select-</option>
                <option value="GR">Glen Rock</option>
                <option value="RW">Ridgewood</option>
                <option value="FL">Fair Lawn</option>
                <option value="OH">Other</option>
            </select></td>
            <td align="left"><span id="msg_town"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Adults<span class="required">*</span> :
            </td>
            <td align="left"><input type="text" id="adults" name="adults" value="" class="numBox"></td>
            <td align="left"><span id="msg_adults"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Children (Ages 5 - 11)<span class="required">*</span> :
            </td>
            <td align="left"><input type="text" id="children" name="children" value="0" class="numBox"></td>
            <td align="left"><span id="msg_children"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Participate in cultural program :</td>
            <td align="left" colspan="2"><input type="checkbox" id="participant" name="participant" value="true"
              class="numBox"></td>
          </tr>
          <tr>
            <td align="right">Volunteer for the event :</td>
            <td align="left" colspan="2"><input type="checkbox" id="volunteer" name="volunteer" value="true"
              class="numBox"></td>
          </tr>
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
        </table>
      </div>
      <div id="step-3">
        <h2 class="StepTitle">Step 3: Payment Gateway</h2>
        <table>
          <tr>
            <td align="left">
              <p>&nbsp;</p>
              <h1>
                Total charge for the event: $<span id="totalCharge"></span>
              </h1>

              <ul>
                <li>Click on the "Pay Now" button below</li>
                <li>Pay by credit or debit card.</li>
                <li>Hit Finish once done, to complete the registration.</li>
                <li><b>There are no refunds or transfers available. All payments are final.</b></li>
              </ul>
            </td>
          </tr>
          <tr>
            <td align="center">
              <button id="customButton" class="payNow">Purchase Tickets!</button> <script type="text/javascript"
                src="static/js/stripe-payment.js"></script>
            </td>
          </tr>
        </table>
      </div>
      <div id="step-4">
        <h2 class="StepTitle">Step 4: Print Ticket</h2>
        <table>
          <tr>
            <td align="center">&nbsp;</td>
          </tr>
          <tr>
            <td align="left">
              <p id="confirmationMessage">&nbsp;</p>
              <p>Please make a copy of this page for your reference. See you at the event!</p>
              <p>You should also be receiving an email from Stripe.com with the details of the charge. Your credit card will have a charge from "GRIC Payment"</p>
              <p>If you have any further questions, you can email at <span id="eventContactEmailAgain">&nbsp;</span></p>
              <p>&nbsp;</p>
              <h2 align="center" id="eventAddressAgain">&nbsp;</h2>
              <h2 align="center" id="eventTimeAgain">&nbsp;</h2>
            </td>
          </tr>
        </table>
      </div>
    </div>
    <!-- End SmartWizard Content -->
  </form>
  <h6>
    Developed by: <a href="http://protonfever.blogspot.com/">Varun Mehta</a>
  </h6>
</body>
</html>

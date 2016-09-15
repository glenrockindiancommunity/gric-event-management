<html>
<head>
<title>Glen Rock Indian Community - Diwali Registration</title>

<!-- Include CSS -->
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">

<!-- Include JS -->
<script src="https://checkout.stripe.com/checkout.js"></script>
<script type="text/javascript" src="static/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="static/js/jquery.smartWizard.js"></script>
<script type="text/javascript" src="static/js/registration.js"></script>
</head>
<body>
  <h1>Glen Rock Indian Community Diwali Registration - 2016</h1>
  <form action="#" method="POST" id="mainForm">
    <input type='hidden' name="issubmit" value="1">
    <!-- Tabs -->
    <div id="wizard" class="swMain">
      <ul>
        <li><a href="#step-1"> <span class="stepNumber">1</span> <span class="stepDesc"> Welcome<br /> <small>Happy
                Diwali!</small>
          </span>
        </a></li>
        <li><a href="#step-2"> <span class="stepNumber">2</span> <span class="stepDesc"> Family Details<br />
              <small>Provide family details</small>
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
              <h2 align="center">The Glen Rock Indian Community proudly presents the 3rd annual "Diwali Dhamaka"</h2>

              <ul>
                <li>Participate in Laxmi puja, diya decoration and kids activities</li>
                <li>Enjoy cultural performances and programs</li>
              </ul>

              <h2 align="center">
                7:00 PM - 11:00 PM<br />Saturday, October 22, 2016
              </h2>
            </td>
          </tr>
          <tr>
            <td colspan="3" align="left">&nbsp;</td>
          </tr>
          <tr>
            <td align="left" colspan="3">
              <p align="center">
                <iframe
                  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3016.20469942012!2d-74.099133584143!3d40.88932443468427!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2f96256082115%3A0x3b90c1b864be0f25!2sThe+Excelsior+Catering!5e0!3m2!1sen!2sus!4v1473460458353"
                  width="600" height="450" frameborder="0" style="border: 0" allowfullscreen></iframe>
              </p>
              <h2 align="center">
                The Excelsior, <br />190 US-46, Saddle Brook, NJ 07663 <br /> <br />
              </h2>
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
                <li>The event will accommodate first 200 people who register</li>
                <li>Registration closes October 10th</li>
                <li>For volunteering OR if interested to perform, please update the form accordingly, and someone will
                  get in touch with you ASAP</li>
              </ol>

              <p>Entry - All Inclusive of appetizer, dinner, and deserts, applicable taxes &amp; gratuity</p>

              <ul>
                <li>Ages under 5 - free</li>
                <li>Ages 5 - 11 - $20</li>
                <li>Ages 12+ - $40</li>
              </ul>

              <p>All transaction will be charged 2.9% transaction fee + 30 cents for every successful transaction.</p>
              <p>All non-residents of Glen Rock will be charged an extra 10% of the total.</p>
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
                <li>Hit Finish once done, to complete the registation.</li>
                <li><b>There are no refunds or transfers available. All payments are final.</b></li>
              </ul>
            </td>
          </tr>
          <tr>
            <td align="center">
              <button id="customButton" class="payNow">Purchase Tickets!</button> <script>
															var handler = StripeCheckout
																	.configure({
																		key : "pk_test_8nOh4pljYTX09ZXSIAB9FB1o",
																		image : "static/images/diya.png",
																		locale : "auto",
																		token : function(
																				token) {
																			// You can access the token ID with `token.id`.
																			// Get the token ID to your server-side code for use.
																			$(
																					"stripeReceiptNumber")
																					.val(
																							token.id);
																			submitPageForm(token.id);
																		}
																	});

															document
																	.getElementById(
																			'customButton')
																	.addEventListener(
																			'click',
																			function(
																					e) {
																				// Open Checkout with further options:
																				handler
																						.open({
																							name : 'GRIC Diwali - 2016',
																							description : 'Diwali Dhamaka Registration Payment',
																							zipCode : true
																						});
																				e
																						.preventDefault();
																			});

															// Close Checkout on page navigation:
															window
																	.addEventListener(
																			'popstate',
																			function() {
																				handler
																						.close();
																			});
														</script>
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
              <p>Please make a copy of this page for your reference. See you at the party!</p>

              <p>&nbsp;</p>
              <h2 align="center">
                The Excelsior, <br />190 US-46, Saddle Brook, NJ 07663 <br /> <br />
              </h2>
              <h2 align="center">
                7:00 PM - 11:00 PM<br />Saturday, October 22, 2016
              </h2>
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

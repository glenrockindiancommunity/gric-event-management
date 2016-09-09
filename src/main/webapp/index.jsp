<html>
<head>
<title>Glen Rock Indian Community - Diwali Registration</title>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="static/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="static/js/jquery.smartWizard-2.0.min.js"></script>
<script type="text/javascript" src="static/js/registration.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// Smart Wizard     	
		$('#wizard').smartWizard({
			transitionEffect : 'fade',
			enableAllSteps: false,
			onLeaveStep : leaveAStepCallback,
			onFinish : onFinishCallback,
			enableFinishButton : false
		});

		function leaveAStepCallback(obj) {
			var step_num = obj.attr('rel');
			return validateSteps(step_num);
		}

		function onFinishCallback() {
			if (validateAllSteps()) {
				$('form').submit();
			}
		}
	});
</script>
</head>
<body>
  <h1>Glen Rock Indian Community Diwali Registration - 2016</h1>
  <form action="#" method="POST">
    <input type='hidden' name="issubmit" value="1">
    <!-- Tabs -->
    <div id="wizard" class="swMain">
      <ul>
        <li><a href="#step-1"> <span class="stepNumber">1</span> <span class="stepDesc"> Basic Info<br /> <small>Provide
                basic info</small>
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
        <h2 class="StepTitle">Step 1: Basic Info</h2>
        <table>
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td align="left" colspan="3">
              <h2 align="center">The Glen Rock Indian Community proudly presents the 3rd annual "Diwali Dhamaka".</h2>

              <ul>
                <li>Participate in Laxmi puja, diya decoration and kids activities.</li>
                <li>Enjoy cultural performances and musical Antakshari.</li>
              </ul>

              <p align="center">
                <b>7:00 PM - 11:00 PM<br />Saturday, October 22, 2016 <br /> <br /> The Excelsior, <br />190 US-46,
                  Saddle Brook, NJ 07663 <br /></b>
              </p>

              <p>&nbsp;</p>
            </td>
          </tr>
          <tr>
            <td align="right">Last Name :</td>
            <td align="left"><input type="text" id="familyNameCode" name="familyNameCode" value="" class="txtBox"></td>
            <td align="left"><span id="msg_familyNameCode"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Town :</td>
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
            <td align="right">Adults :</td>
            <td align="left"><input type="text" id="adults" name="adults" value="" class="numBox"></td>
            <td align="left"><span id="msg_adults"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Children :</td>
            <td align="left"><input type="text" id="children" name="children" value="0" class="numBox"></td>
            <td align="left"><span id="msg_children"></span>&nbsp;</td>
          </tr>
          <tr>
            <td colspan="3">
              <p>Please note
                <ol>
                  <li>The event will accommodate the first 125 people.</li>
                  <li>Registration closes October 2nd</li>
                  <li>For volunteering OR if interested to perform, please update the form accordingly, and someone will
                    get in touch with you ASAP</li>
                  <li>First entries to Glen Rock, event may be opened up to non GR families based on initial response.</li>
                </ol>

                <p>Entry - All Inclusive of appetizer, dinner, and deserts, applicable taxes &amp; gratuity</p>

                <ul>
                  <li>Ages under 5 - free</li>
                  <li>Ages 5 - 11 - $20</li>
                  <li>Ages 12+ - $40</li>
                </ul>

                <p>We look forward to seeing you.</p>
            </td>
          </tr>
        </table>
      </div>
      <div id="step-2">
        <h2 class="StepTitle">Step 2: Family Details</h2>
        <table id="tablesStep2">
          <tr>
            <td align="center" colspan="6">&nbsp;</td>
          </tr>
          <tr>
            <th width="20%">First Name</th>
            <th width="20%">Last Name</th>
            <th width="20%">Email</th>
            <th width="15%">Gender</th>
            <th width="7%">Age</th>
            <th width="7%">Participate</th>
            <th width="7%">Volunteer</th>
          </tr>
          <tr id="members_0">
            <td align="center"><input type="text" id="firstname_0" name="firstname_0" value="" class="txtBox"></td>
            <td align="center"><input type="text" id="lastname_0" name="lastname_0" value="" class="txtBox"></td>
            <td align="center"><input type="text" id="email_0" name="email_0" value="" class="txtBox"></td>
            <td align="center"><select id="gender_0" name="gender_0" class="txtBox">
                <option value="">-select-</option>
                <option value="Female">Female</option>
                <option value="Male">Male</option>
            </select></td>
            <td align="center"><input type="text" id="age_0" name="age_0" value="" class="numBox"></td>
            <td align="center"><input type="checkbox" id="participate_0" name="participate_0" value="" class="numBox"></td>
            <td align="center"><input type="checkbox" id="volunteer_0" name="volunteer_0" value="" class="numBox"></td>
          </tr>
        </table>
      </div>
      <div id="step-3">
        <h2 class="StepTitle">Step 3: Payment Gateway</h2>
        <table >
          <tr>
            <td>
              <p>&nbsp;</p>
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
              <form action="/your-charge-code" method="POST">
                <script src="https://checkout.stripe.com/checkout.js" class="stripe-button"
                  data-key="pk_test_8nOh4pljYTX09ZXSIAB9FB1o" data-amount="2000" data-name="GRIC Diwali - 2016"
                  data-description="Payment for the Diwali party" data-image="/img/documentation/checkout/marketplace.png"
                  data-billing-address="true" data-email="Preload from previous screen" data-locale="auto"></script>
              </form>
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
            <td>
              <p>
                Thank you for your registration. Your identification code for the event is: <b>registration_id</b>
              </p>
              <p>
                Your payment confirmation number is: <b>payment_confirmation_id</b>
              </p>
              <p>Please make a copy of these for your reference. You'll receive an email from us confirming your booking
                and updates about the event as it gets closer.</p>
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

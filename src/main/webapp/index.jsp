<html>
<head>
<title>Glen Rock Indian Community - Diwali Registration</title>
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//cloud.typography.com/711858/764882/css/fonts.css" />

<script type="text/javascript" src="static/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="static/js/jquery.smartWizard-2.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// Smart Wizard     	
		$('#wizard').smartWizard({
			transitionEffect : 'slideleft',/* onLeaveStep:leaveAStepCallback,*/
			onFinish : onFinishCallback,
			enableFinishButton : true
		});

		/*   function leaveAStepCallback(obj){
		 var step_num= obj.attr('rel');
		 return validateSteps(step_num);
		 }
		 */
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
        <table cellspacing="3" cellpadding="3" align="center">
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" colspan="3">
              <p>Glen Rock Indian Community is back again with a Diwali Dhamaka for 2016. Fill in the registration to
                register for the event.</p>
              <p>&nbsp;</p>
            </td>
          </tr>
          <tr>
            <td align="right">Last Name :</td>
            <td align="left"><input type="text" id="username" name="username" value="" class="txtBox"></td>
            <td align="left"><span id="msg_username"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Town :</td>
            <td align="left"><input type="text" id="password" name="password" value="" class="txtBox"></td>
            <td align="left"><span id="msg_password"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Adults :</td>
            <td align="left"><input type="text" id="cpassword" name="cpassword" value="" class="txtBox"></td>
            <td align="left"><span id="msg_cpassword"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Kids :</td>
            <td align="left"><input type="text" id="cpassword" name="cpassword" value="" class="txtBox"></td>
            <td align="left"><span id="msg_cpassword"></span>&nbsp;</td>
          </tr>

        </table>
      </div>
      <div id="step-2">
        <h2 class="StepTitle">Step 2: Family Details</h2>
        <table cellspacing="3" cellpadding="3" align="center">
          <tr>
            <td align="center" colspan="3">&nbsp;</td>
          </tr>
          <tr>
            <td align="right">First Name :</td>
            <td align="left"><input type="text" id="firstname" name="firstname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_firstname"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Last Name :</td>
            <td align="left"><input type="text" id="lastname" name="lastname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_lastname"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Email :</td>
            <td align="left"><input type="text" id="lastname" name="lastname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_lastname"></span>&nbsp;</td>
          </tr>

          <tr>
            <td align="right">Gender :</td>
            <td align="left"><select id="gender" name="gender" class="txtBox">
                <option value="">-select-</option>
                <option value="Female">Female</option>
                <option value="Male">Male</option>
            </select></td>
            <td align="left"><span id="msg_gender"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Age :</td>
            <td align="left"><input type="text" id="lastname" name="lastname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_lastname"></span>&nbsp;</td>
          </tr>
          <tr>
            <td align="right">Participant :</td>
            <td align="left"><input type="text" id="lastname" name="lastname" value="" class="txtBox"></td>
            <td align="left"><span id="msg_lastname"></span>&nbsp;</td>
          </tr>

        </table>
      </div>
      <div id="step-3">
        <h2 class="StepTitle">Step 3: Payment Gateway</h2>
        <table cellspacing="3" cellpadding="3" align="center">
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
                  data-billing-address="true" data-email="Preload from previous screen" data-locale="auto"> </script>
              </form>
            </td>
          </tr>
        </table>
      </div>
      <div id="step-4">
        <h2 class="StepTitle">Step 4: Print Ticket</h2>
        <table cellspacing="3" cellpadding="3" align="center">
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

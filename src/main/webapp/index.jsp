<html>
<head>
<title>Glen Rock Indian Community - Diwali Registration</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-steps/1.1.0/jquery.steps.min.js" 
	integrity="sha256-yUWanhHkxj+3ow0qZE6AtzP8lZkwLvPagULL6PnZMz0=" crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.1.0.slim.min.js"   
	integrity="sha256-cRpWjoSOw5KcyIOaZNo4i6fZ9tKPhYYb6i5T9RSVJG8=" crossorigin="anonymous"></script>

</head>
<body>
  <p>(*) Mandatory</p>

	<form id="diwali-registration" action="#">
	    <h2>Registration</h2>
	    <fieldset>
	        <legend>Family Information</legend>
	        <label for="userName-2">Last Name *</label>
	        <input id="userName-2" name="userName" type="text" class="required">
	        <label for="password-2">Town *</label>
	        <input id="password-2" name="password" type="text" class="required">
	        <label for="confirm-2">Adults *</label>
	        <input id="confirm-2" name="confirm" type="text" class="required">
	        <label for="confirm-2">Kids *</label>
	        <input id="confirm-2" name="confirm" type="text" class="required">
	    </fieldset>
	 
	    <h2>Family Members</h2>
	    <fieldset>
	        <legend>Profile Information</legend>
	 
	        <label for="name-2">First name *</label>
	        <input id="name-2" name="name" type="text" class="required">
	        <label for="surname-2">Last name *</label>
	        <input id="surname-2" name="surname" type="text" class="required">
	        <label for="email-2">Email *</label>
	        <input id="email-2" name="email" type="text" class="required email">
	        <label for="address-2">Gender</label>
	        <input id="address-2" name="address" type="text">
	        <label for="age-2">Age</label>
	        <input id="age-2" name="age" type="text" class="required number">
	        <input id="participant-2" name="participant" type="checkbox">	        
	        <label for="participant-2">Participate in cultural program at the party</label>
	    </fieldset>
	 
	    <h3>Payment</h3>
	    <fieldset>
	        <legend>Let's use Stripe for payment.</legend>
	 
	        <p>Click on the button below to launch the payment gateway</p>
	    </fieldset>
	 
	    <h3>Confirmation</h3>
	    <fieldset>
	        <legend>Terms and Conditions</legend>
	 
	        <input id="acceptTerms-2" name="acceptTerms" type="checkbox" class="required"> <label for="acceptTerms-2">I agree with the Terms and Conditions.</label>
	    </fieldset>
	</form>
</body>
</html>

function validateAllSteps() {
	var isStepValid = true;

	if (validateStep1() == false) {
		isStepValid = false;
		$('#wizard').smartWizard('setError', {
			stepnum : 1,
			iserror : true
		});
	} else {
		$('#wizard').smartWizard('setError', {
			stepnum : 1,
			iserror : false
		});
	}

	if (validateStep2() == false) {
		isStepValid = false;
		$('#wizard').smartWizard('setError', {
			stepnum : 2,
			iserror : true
		});
	} else {
		$('#wizard').smartWizard('setError', {
			stepnum : 2,
			iserror : false
		});
	}

	if (!isStepValid) {
		$('#wizard').smartWizard('showMessage',
				'Please correct the errors in the steps and continue');
	}

	return isStepValid;
}

function validateSteps(step) {
	var isStepValid = true;
	// validate step 1
	if (step == 1) {
		if (validateStep1() == false) {
			isStepValid = false;
			$('#wizard').smartWizard(
					'showMessage',
					'Please correct the errors in Step' + step
							+ ' and click next.');
			$('#wizard').smartWizard('setError', {
				stepnum : step,
				iserror : true
			});
		} else {
			$('#wizard').smartWizard('setError', {
				stepnum : step,
				iserror : false
			});
		}
	}

	// validate step3
	if (step == 3) {
		if (validateStep2() == false) {
			isStepValid = false;
			$('#wizard').smartWizard(
					'showMessage',
					'Please correct the errors in Step' + step
							+ ' and click next.');
			$('#wizard').smartWizard('setError', {
				stepnum : step,
				iserror : true
			});
		} else {
			$('#wizard').smartWizard('setError', {
				stepnum : step,
				iserror : false
			});
		}
	}

	return isStepValid;
}

function validateStep1() {
	var isValid = true;
	// Validate lastname
	var ln = $('#familyNameCode').val();
	if (!ln && ln.length <= 0) {
		isValid = false;
		$('#msg_familyNameCode').html('Please provide a Lastname').show();
	} else {
		$('#msg_familyNameCode').html('').hide();
	}

	// validate town
	var town = $('#town').val();
	if (!town && town.length <= 0) {
		isValid = false;
		$('#msg_town').html('Please select a town').show();
	} else {
		$('#msg_town').html('').hide();
	}

	// validate adults
	var adults = $('#adults').val();
	if (!adults && adults.length <= 0 && (adults + 0) < 1) {
		isValid = false;
		$('#msg_adults').html('Please provide a valid adult count').show();
	} else {
		$('#msg_adults').html('').hide();
	}

	// validate children
	var children = $('#children').val();
	if (!children && children.length <= 0 && children < 0) {
		isValid = false;
		$('#msg_children').html('Please provide a valid children count').show();
	} else {
		$('#msg_children').html('').hide();
	}

	// validate password match
	// if (pw && pw.length > 0 && cpw && cpw.length > 0) {
	// if (pw != cpw) {
	// isValid = false;
	// $('#msg_cpassword').html('Password mismatch').show();
	// } else {
	// $('#msg_cpassword').html('').hide();
	// }
	// }
	
	if (isValid) {
		var total = parseInt(adults) + parseInt(children);
		addRows(total);
	}
	
	return isValid;
}

function resetRows() {
	
}

function addRows(rows) {
	for (var i = 1; i < rows; i++) {
		var row = $("#tablesStep2 tr").last().clone();
		var oldId = Number(row.attr('id').slice(-1));
		var id = oldId + 1;
		row.attr('id', 'members_' + id);
		row.find('#firstname_' + oldId).attr('id', 'firstname_' + id);
		row.find('#lastname_' + oldId).attr('id', 'lastname_' + id);
		row.find('#email_' + oldId).attr('id', 'email_' + id);
		row.find('#gender_' + oldId).attr('id', 'gender_' + id);
		row.find('#age_' + oldId).attr('id', 'age_' + id);
		row.find('#participate_' + oldId).attr('id', 'participate_' + id);
		row.find('#volunteer_' + oldId).attr('id', 'volunteer_' + id);

		$('#tablesStep2').append(row);
	}
}

function validateStep2() {
	var isValid = true;
	// validate email email
	var email = $('#email').val();
	if (email && email.length > 0) {
		if (!isValidEmailAddress(email)) {
			isValid = false;
			$('#msg_email').html('Email is invalid').show();
		} else {
			$('#msg_email').html('').hide();
		}
	} else {
		isValid = false;
		$('#msg_email').html('Please enter email').show();
	}
	return isValid;
}

function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(
			/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
	return pattern.test(emailAddress);
}

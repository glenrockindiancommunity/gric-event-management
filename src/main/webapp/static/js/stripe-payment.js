function registerStripeJs(event) {
	var handler = StripeCheckout.configure({
		key : 'pk_test_nszotlTHR4kvffxr5YH3HUIm',
		locale : 'auto',
		color : 'blue',
		image : '/static/images/' + event.paymentLogo,
		token : function(token) {
			// You can access the token ID with `token.id`.
			// Get the token ID to your server-side code for use.
			$("stripeReceiptNumber").val(token.id);
			submitPageForm(token.id);
		}
	});

	document.getElementById('customButton').addEventListener('click',
			function(e) {
				// Open Checkout with further options:
				handler.open({
					name : event.name,
					description : 'GRIC - Event Payment',
					zipCode : true
				});
				e.preventDefault();
			});

	// Close Checkout on page navigation:
	window.addEventListener('popstate', function() {
		handler.close();
	});
}
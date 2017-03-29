var handler = StripeCheckout.configure({
	key : "pk_test_8nOh4pljYTX09ZXSIAB9FB1o",
	locale : "auto",
	token : function(token) {
		// You can access the token ID with `token.id`.
		// Get the token ID to your server-side code for use.
		$("stripeReceiptNumber").val(token.id);
		submitPageForm(token.id);
	}
});

document.getElementById('customButton').addEventListener('click', function(e) {
	// Open Checkout with further options:
	handler.open({
		name : $('eventName').text(),
		description : 'Glen Rock Indian Community - Event Registration Payment',
		zipCode : true
	});
	e.preventDefault();
});

// Close Checkout on page navigation:
window.addEventListener('popstate', function() {
	handler.close();
});
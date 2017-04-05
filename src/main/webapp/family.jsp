<html>
<head>
<title>Glen Rock Indian Community - Events</title>
<meta name="viewport" content="width=device-width,initial-scale=1">

<!-- Include CSS -->
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/gric.css" rel="stylesheet" type="text/css">


<!-- Include JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="static/js/jquery-dateFormat.min.js"></script>

<!-- Making List Page Responsive -->
<script type="text/javascript">
	$(document).ready(function() {
		$.get("/family", function(data, status) {
			var families = data._embedded.families;
	    var html = ""
	    var adults = 0;
	    var children = 0;
	    var total = 0;
	    
			for ( var i in families) {
				var family = families[i];
				html += "<tr class=''><td  class=' ' data-title='Name'>" + family.firstname + " " + family.lastname + "</td>" 				
				html += "<td class='text hide-mobile' data-title='Code'>" + family.familyNameCode + "</td>"
				html += "<td class='text ' data-title='Adults'>" + family.adults + "</td>"
        html += "<td class='text ' data-title='Children'>" + family.children + "</td>"
        html += "<td class='text ' data-title='Amount'>" + family.amount + "</td>"
        html += "<td class='text hide-mobile' data-title='Email'>" + family.primaryEmail + "</td>"
        html += "<td class='text hide-mobile' data-title='Town'>" + family.town + "</td>"
        html += "<td class='text hide-mobile' data-title='Stripe'>" + family.stripeReceiptNumber + "</td>"
				html += "</tr>"
				
				adults += parseInt(family.adults);
		    children += parseInt(family.children);
		    total += parseFloat(family.amount);
			}
			
			html +="<tr><td class=' ' data-title='Name'>Total</td>"
		  html +="<td class=' ' data-title='Adults'>" + adults + "</td>"
	    html +="<td class=' ' data-title='Children'>" + children + "</td>"
	    html +="<td class=' ' data-title='Amount'>" + total + "</td></tr>"
			
      $('#table tbody').append(html);
		})
	});
</script>

</head>
<body>
  <h1>Glen Rock Indian Community Events</h1>
  <div class='rg-container'>
    <div class='rg-content'>
      <table id="table" class='rg-table zebra' summary='Hed'>
        <caption class='rg-header'>
          <span class='rg-hed'>Family</span>
          <span class='rg-dek'>Families registered for "event" so far (certain fields are hidden on mobile)</span>
        </caption>
        <thead>
          <tr>
            <th class=' '>Name</th>
            <th class='text hide-mobile'>Code</th>
            <th class='text '>Adults</th>
            <th class='text '>Children</th>
            <th class='text '>Amount</th>
            <th class='text hide-mobile'>Email</th>
            <th class='text hide-mobile'>Town</th>          
            <th class='text hide-mobile'>Stripe</th>
          </tr>
        </thead>
        <tbody id="eventData">
        </tbody>
      </table>
    </div>
  </div>
  <h6 align="center">
    Developed by: <a href="http://protonfever.blogspot.com/">Varun Mehta</a>
  </h6>
</body>
</html>

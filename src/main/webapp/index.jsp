<html>
<head>
<title>Glen Rock Indian Community - Events</title>
<meta http-equiv="refresh" content="0; url=https://www.facebook.com/media/set/?set=a.1311432465576620.1073741857.118298044890074&type=1&l=516d5380ae">
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
		$.get("/event", function(data, status) {
			var events = data._embedded.events;
	    var html = "" 
			for ( var i in events) {
				var event = events[i];
				html += "<tr class=''><td  class=' ' data-title='Name'><a href='/registration.jsp?id="+event.id+"'>" + event.name + "</a></td>" 				
				html += "<td class='text ' data-title='Date'>" + $.format.date(event.startDateTime, "MMM-d-yyyy h:mm a") + " - " + $.format.date(event.endDateTime, "h:mm a") + "</td>"
				html += "<td class='text hide-mobile' data-title='Location'>" + event.location + "</td>"
				html += "<td  class='text ' data-title='Entry Fee'>adults: $" + event.adultCost + " - kids: $" + event.childCost + "</td>"
				html += "</tr>"
			}
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
          <span class='rg-hed'>Events</span>
          <span class='rg-dek'>Current events hosted by Glen Rock Indian Community</span>
        </caption>
        <thead>
          <tr>
            <th class=' '>Name</th>
          <th class='text '>Date</th>
          <th class='text hide-mobile'>Location</th>
          <th class='text '>Entry Fee</th>
          </tr>
        </thead>
        <tbody id="eventData">
        </tbody>
      </table>
    </div>
  </div>
  
  <a href="https://stripe.com/docs/security/stripe"><img alt="Powered By Stripe" src="static/images/powered_by_stripe@2x.png"/></a>
  
  <h6 align="center">
    Developed by: <a href="http://protonfever.blogspot.com/">Varun Mehta</a>
  </h6>
</body>
</html>

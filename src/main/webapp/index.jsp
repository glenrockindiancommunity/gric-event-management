<html>
<head>
<title>Glen Rock Indian Community - Events</title>

<!-- Include CSS -->
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">

<!-- Include JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="static/js/jquery-dateFormat.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$.get("/event", function(data, status) {
			var events = data._embedded.events;
	    var html = "" 
			for ( var i in events) {
				var event = events[i];
				html += "<tr><td><a href='/registration.jsp?id="+event.id+"'>" + event.name + "</a></td>" 				
				html += "<td>" + $.format.date(event.startDateTime, "MMM-d-yyyy h:mm a") + " - " + $.format.date(event.endDateTime, "h:mm a") + "</td>"
				html += "<td>" + event.location + "</td>"
				html += "<td>adults: $" + event.adultCost + " - kids: $" + event.childCost + "</td>"
				html += "</tr>"
			}
      $('#table tbody').append(html);
		})
	});
</script>

</head>
<body>
  <h1>Glen Rock Indian Community Events</h1>

  <table id="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>Entry Fee</th>
      </tr>
    </thead>
    <tbody id="eventData">
    </tbody>
  </table>

  <h6>
    Developed by: <a href="http://protonfever.blogspot.com/">Varun Mehta</a>
  </h6>
</body>
</html>

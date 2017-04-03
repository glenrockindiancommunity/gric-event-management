<html>
<head>
<title>Glen Rock Indian Community - Events</title>

<!-- Include CSS -->
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link href="static/css/smart_wizard.css" rel="stylesheet" type="text/css">

<!-- Include JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="static/js/jquery-dateFormat.min.js"></script>

<!-- Making List Page Responsive -->
<style type="text/css">
  /* info (hed, dek, source, credit) */
.rg-container {
  font-family: 'Lato', Helvetica, Arial, sans-serif;
  font-size: 16px;
  line-height: 1.4;
  margin: 0;
  padding: 1em 0.5em;
  color: #222;
}
.rg-header {
  margin-bottom: 1em;
  text-align: left;
}

.rg-header > * {
  display: block;
}
.rg-hed {
  font-weight: bold;
  font-size: 1.4em;
}
.rg-dek {
  font-size: 1em;
}

.rg-source {
  margin: 0;
  font-size: 0.75em;
  text-align: right;
}
.rg-source .pre-colon {
  text-transform: uppercase;
}

.rg-source .post-colon {
  font-weight: bold;
}

/* table */
table.rg-table {
  width: 100%;
  margin-bottom: 0.5em;
  font-size: 1em;
  border-collapse: collapse;
  border-spacing: 0;
}
table.rg-table tr {
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  text-align: left;
  color: #333;
}
table.rg-table thead {
  border-bottom: 3px solid #ddd;
}
table.rg-table tr {
  border-bottom: 1px solid #ddd;
  color: #222;
}
table.rg-table tr.highlight {
  background-color: #dcf1f0 !important;
}
table.rg-table.zebra tr:nth-child(even) {
  background-color: #f6f6f6;
}
table.rg-table th {
  font-weight: bold;
  padding: 0.35em;
  font-size: 0.9em;
}
table.rg-table td {
  padding: 0.35em;
  font-size: 0.9em;
}
table.rg-table .highlight td {
  font-weight: bold;
}
table.rg-table th.number, td.number {
  text-align: right;
}

/* media queries */
@media screen and (max-width: 600px) {
.rg-container {
  max-width: 600px;
  margin: 0 auto;
}
table.rg-table {
  width: 100%;
}
table.rg-table tr.hide-mobile, table.rg-table th.hide-mobile, table.rg-table td.hide-mobile {
  display: none;
}
table.rg-table thead {
  display: none;
}
table.rg-table tbody {
  width: 100%;
}
table.rg-table tr, table.rg-table th, table.rg-table td {
  display: block;
  padding: 0;
}
table.rg-table tr {
  border-bottom: none;
  margin: 0 0 1em 0;
  padding: 0.5em;
}
table.rg-table tr.highlight {
  background-color: inherit !important;
}
table.rg-table.zebra tr:nth-child(even) {
  background-color: none;
}
table.rg-table.zebra td:nth-child(even) {
  background-color: #f6f6f6;
}
table.rg-table tr:nth-child(even) {
  background-color: none;
}
table.rg-table td {
  padding: 0.5em 0 0.25em 0;
  border-bottom: 1px dotted #ccc;
  text-align: right;
}
table.rg-table td[data-title]:before {
  content: attr(data-title);
  font-weight: bold;
  display: inline-block;
  content: attr(data-title);
  float: left;
  margin-right: 0.5em;
  font-size: 0.95em;
}
table.rg-table td:last-child {
  padding-right: 0;
  border-bottom: 2px solid #ccc;
}
table.rg-table td:empty {
  display: none;
}
table.rg-table .highlight td {
  background-color: inherit;
  font-weight: normal;
}
}

</style>
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
  <h6 align="center">
    Developed by: <a href="http://protonfever.blogspot.com/">Varun Mehta</a>
  </h6>
</body>
</html>

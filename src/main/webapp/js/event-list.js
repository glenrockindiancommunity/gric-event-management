$(document).ready(
	function() {
	    $.get("/event", function(data, status) {
		var events = data._embedded.events;
		var html = ""
		for ( var i in events) {
		    var event = events[i];
		    html += '<li data-role="list-divider">' + $.format.date(event.startDateTime, "ddd, MMMM d, yyyy")
			    + '<span class="ui-li-count">capacity: ' + event.maxCapacity + '</span></li>'
		    html += '<li>'
		    html += '<a href="#event">'
		    html += '<h2>' + event.name + '</h2>'
		    html += '<p>' + event.description + '</p>'
		    html += '<p>' + event.location + '</p>'
		    html += '<p>Adults: $' + event.adultCost + ' - Kids: $' + event.childCost + '</p>'
		    html += '<p class="ui-li-aside"><strong>' + $.format.date(event.startDateTime, "h:mm a")
			    + '</strong></p>'
		    html += '</a>'
		    html += '</li>'
		}
		$('#eventList').append(html);
		$('#eventList').listview('refresh');
	    })
	});
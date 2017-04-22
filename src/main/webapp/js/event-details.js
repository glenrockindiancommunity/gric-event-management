		    $.get(url, function(data, status) {
		    	registerStripeJs(data);
		    	populateEventDetails(data);
		    	populateEventCal(data);
		});

$(document).ready(
	function() {
	    $.get("/event", function(data, status) {
		var events = data._embedded.events;
		var html = ""
		for ( var i in events) {
		    var event = events[i];
		    $('#eventDescription').text(event.description)
		    $('#eventDateTime').append($.format.date(event.startDateTime, "ddd, MMMM d, yyyy - hh:mm A") +  + '-' + $.format.date(event.endDateTime, "hh:mm A"))
		    $('#eventAddress').text(event.location)
		    $('#eventEmail').text(event.contactEmail)
		    $('#eventPricing').append('Adults: $' + event.adultCost + ' - Kids: $' + event.childCost)
		}
		$('#eventList').append(html);
		$('#eventList').listview('refresh');
	    })
	});
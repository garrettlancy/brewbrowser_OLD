$(document).ready(function () {
	function myMap() {
		var mapOptions = {
				center: new google.maps.LatLng(39.9417, -82.9921),
				zoom: 6,
				draggable: false,
				center: new google.maps.LatLng(40.4173, -82.9071),
				zoom: 6,
				draggable: true,
				scrollwheel: false,
				mapTypeId: google.maps.MapTypeId.roadmap
		}
		map = new google.maps.Map(document.getElementById("map"), mapOptions);
	}
	 
	$.ajax({
		url:"breweryListJSON", type:"GET", datatype:"JSON"
	}).done(function (json){

		var infoWindow = new google.maps.InfoWindow();
		var geocoder = new google.maps.Geocoder();

		$.each(json, function(index, data) {
			geocoder.geocode( {address: data.mapsAddress }, function(results, status) 
					{
				if (status == google.maps.GeocoderStatus.OK) 
				{
					map.setCenter(results[0].geometry.location);//center the map over the result
					//place a marker at the location
					var marker = new google.maps.Marker(
							{
								map: map,
								title: data.name,
								position: results[0].geometry.location,
								icon:'img/brew-marker.png'
							});
					console.log(marker);
				} else {
					alert('Geocode was not successful for the following reason: ' + status);
				}
				google.maps.event.addListener(marker, "click", function(e) {
					infoWindow.setContent(data.name);
					infoWindow.open(map, marker);
				});

					});
		});
	});

	myMap();
	
	(function() {

		$('#live-chat header').on('click', function() {

			$('.chat').slideToggle(300, 'swing');
			$('.chat-message-counter').fadeToggle(300, 'swing');

		});

		$('.chat-close').on('click', function(e) {

			e.preventDefault();
			$('#live-chat').fadeOut(300);

		});

	}) ();

});





<%@ include file="common/header.jspf"%>
<div class="container contain-center">
	<div class="col-md-8 text-center">
	<div class="col-md-12">
	<div class="col-md-10 col-md-offset">
	<br>
		<c:url var="imageUrl" value="/img/thumbnails/${brewery.imgUrl}" />
		<img src="${imageUrl}"><br>
		<h2>
			<c:out value="${brewery.name}" />
		</h2>
		<br>
		<c:out value="${brewery.description}" />
		<br>
		</div>
	</div>
	<div class="col-md-12 contain-center">
	<div class="col-md-10 col-md-offset text-center">
	<c:if test="${!beer.isEmpty()}">
	<c:forEach var="beer" items="${beers}">
	<div class="col-md-6">
		<c:url var="beerDetailsUrl" value="/beerDetails">
			<c:param name="beerId" value="${beer.beerId}" />
		</c:url>
		<a href="${beerDetailsUrl}">
			<div class="text-center">
				<div class="brewery-tile">
					<c:url var="imageUrl" value="/img/thumbnails/${beer.imgUrl}"/>
					<img src="${imageUrl}" class="img-responsive"><br>
					<div>${beer.name}</div>
				</div>
			</div>
		</a>
		</div>
	</c:forEach>
	</c:if>
	</div>
	</div>
	</div>
	<div class="col-md-4 text-center ">
	<br>
	<div>
	<c:out value="${brewery.mapsAddress}" />
	<img src="https://maps.googleapis.com/maps/api/staticmap?center=9964+Crescent+Park+Dr.+%0D%0AWest+Chester%2C+OH+45069&zoom=14&size=200x200&key=AIzaSyBs3CPsS3OfzFZ_qUA6hQNEX3SNCUi29V8" />
	</div>
	
	<div class="col-md-12 details-hours">
		<h3>Details</h3>
		
			<c:out value="${brewery.address}" />
			<br>
			<c:if test="${brewery.address2 != null}">
				<c:out value="${brewery.address2}" />
				<br>
			</c:if>
			<c:out value="${brewery.city}, ${brewery.state} ${brewery.zipCode}" />
		
		<br>
		<p>
			Website: <a href="${brewery.website}"><c:out
					value="${brewery.website}" /></a>
		</p>
		<c:out value="Phone: ${brewery.phoneNumber}" />
		<br>


		<c:choose>
			<c:when test="${brewery.hasFood == true}">
				<br>
				<c:out value="Has Food: Yes" />
			</c:when>
			<c:otherwise>
				<br>
				<c:out value="Has Food: No" />
			</c:otherwise>
		</c:choose>
		</div>
		<div class="col-md-12">
			<br>
			<h4>Hours of Operation:</h4>
			<c:out value="Sunday: ${brewery.sundayHours}" />
			<br>
			<c:out value="Monday: ${brewery.mondayHours}" />
			<br>
			<c:out value="Tuesday: ${brewery.tuesdayHours}" />
			<br>
			<c:out value="Wednesday: ${brewery.wednesdayHours}" />
			<br>
			<c:out value="Thursday: ${brewery.thursdayHours}" />
			<br>
			<c:out value="Friday: ${brewery.fridayHours}" />
			<br>
			<c:out value="Saturday: ${brewery.saturdayHours}" />
			<br>
		</div>
	</div>
	
</div>

<%@ include file="common/footer.jspf"%>
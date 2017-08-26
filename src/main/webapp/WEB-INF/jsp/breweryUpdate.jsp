<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf"%>

<div class="container">
	<c:if test="${message != null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${message}" />
		</div>
		<br>
	</c:if>
</div>
<div class="container row contain-center">
	<div class="col-md-6 col-sm-6" id="register">
		<h2>Brewery Update</h2>
		<c:url var="formAction" value="/breweryUpdate" />
		<form:form id="form0" action="${formAction}" method="POST"
			modelAttribute="brewery">

			<div>
				<label for="name">Brewery Name</label><br>
				<form:input path="name" class="textbox"
					placeholder="Enter Brewery Name" />
				<form:errors path="name" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="password">Brewery Password</label><br>
				<form:input path="password" type="password" class="textbox"
					placeholder="Enter Brewery Password" />
				<form:errors path="password" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="confirmPassword">Confirm Password</label><br>
				<form:input path="confirmPassword" type="password" class="textbox"
					placeholder="Confirm Password" />
				<form:errors path="confirmPassword" cssClass="error" />
				<form:errors path="passwordMatching" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="address">Brewery Address</label><br>
				<form:input path="address" class="textbox"
					placeholder="Enter Brewery Address" />
				<form:errors path="address" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="address2">Brewery Address 2</label><br>
				<form:input path="address2" class="textbox" />
			</div>
			<br>
			<div>
				<label for="city">Brewery City</label><br>
				<form:input path="city" class="textbox"
					placeholder="Enter Brewery City" />
				<form:errors path="city" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="state">Brewery State</label><br>
				<form:select path="state" class="required">
					<form:option value="" label="Select a State" />
					<form:option value="AL" label="Alabama" />
					<form:option value="AK" label="Alaska" />
					<form:option value="AZ" label="Arizona" />
					<form:option value="AR" label="Arkansas" />
					<form:option value="CA" label="California" />
					<form:option value="CO" label="Colorado" />
					<form:option value="CT" label="Connecticut" />
					<form:option value="DE" label="Delaware" />
					<form:option value="DC" label="District Of Columbia" />
					<form:option value="FL" label="Florida" />
					<form:option value="GA" label="Georgia" />
					<form:option value="HI" label="Hawaii" />
					<form:option value="ID" label="Idaho" />
					<form:option value="IL" label="Illinois" />
					<form:option value="IN" label="Indiana" />
					<form:option value="IA" label="Iowa" />
					<form:option value="KS" label="Kansas" />
					<form:option value="KY" label="Kentucky" />
					<form:option value="LA" label="Louisiana" />
					<form:option value="ME" label="Maine" />
					<form:option value="MD" label="Maryland" />
					<form:option value="MA" label="Massachusetts" />
					<form:option value="MI" label="Michigan" />
					<form:option value="MN" label="Minnesota" />
					<form:option value="MS" label="Mississippi" />
					<form:option value="MO" label="Missouri" />
					<form:option value="MT" label="Montana" />
					<form:option value="NE" label="Nebraska" />
					<form:option value="NV" label="evada" />
					<form:option value="NH" label="New Hampshire" />
					<form:option value="NJ" label="New Jersey" />
					<form:option value="NM" label="New Mexico" />
					<form:option value="NY" label="New York" />
					<form:option value="NC" label="North Carolina" />
					<form:option value="ND" label="North Dakota" />
					<form:option value="OH" label="Ohio" />
					<form:option value="OK" label="Oklahoma" />
					<form:option value="OR" label="Oregon" />
					<form:option value="PA" label="Pennsylvania" />
					<form:option value="RI" label="Rhode Island" />
					<form:option value="SC" label="South Carolina" />
					<form:option value="SD" label="South Dakota" />
					<form:option value="TN" label="Tennessee" />
					<form:option value="TX" label="Texas" />
					<form:option value="UT" label="Utah" />
					<form:option value="VT" label="Vermont" />
					<form:option value="VA" label="Virginia" />
					<form:option value="WA" label="Washington" />
					<form:option value="WV" label="West Virginia" />
					<form:option value="WI" label="Wisconsin" />
					<form:option value="WY" label="Wyoming" />
				</form:select>
				<form:errors path="state" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="zipCode">Brewery Zip Code</label><br>
				<form:input path="zipCode" class="textbox"
					placeholder="Enter Brewery Zip Code" />
				<form:errors path="zipCode" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="hasFood">Does you Brewery have food?</label><br>
				<form:radiobutton path="hasFood" label="Yes" value="true" />
				<br>
				<form:radiobutton path="hasFood" label="No" value="false" />
				<form:errors path="hasFood" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="description">Brewery Description</label><br>
				<form:textarea class="textarea" path="description" rows="5"
					cols="80" placeholder="Enter Brewery Description"></form:textarea>
			</div>
			<br>
			<div>
				<label for="website">Brewery Website URL</label><br>
				<form:input class="textbox" path="website" type="text"
					placeholder="Enter Brewery Website" />
				<form:errors path="website" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="phoneNumber">Brewery Phone Number</label><br>
				<form:input class="textbox" path="phoneNumber" type="tel"
					placeholder="Enter Brewery Phone #" />
				<form:errors path="phoneNumber" cssClass="error" />
			</div>
			<br>
			<div>
				<label for="sundayHours">Sunday Hours</label><br>
				<form:input class="textbox" path="sundayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="mondayHours">Monday Hours</label><br>
				<form:input class="textbox" path="mondayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="tuesdayHours">Tuesday Hours</label><br>
				<form:input class="textbox" path="tuesdayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="wednesdayHours">Wednesday Hours</label><br>
				<form:input class="textbox" path="wednesdayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="thursdayHours">Thursday Hours</label><br>
				<form:input class="textbox" path="thursdayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="fridayHours">Friday Hours</label><br>
				<form:input class="textbox" path="fridayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>
			<div>
				<label for="saturdayHours">Saturday Hours</label><br>
				<form:input class="textbox" path="saturdayHours"
					placeholder="12pm - 12am" />
			</div>
			<br>

			<form:input type="hidden" path="breweryId" />
			<input type="submit" name="action" value="Update" />

		</form:form>
		<br> <br>
		<div>
			<a href="${brewerHomeUrl}"><button type="button"
					class="cancelbtn">Cancel</button></a>
		</div>
	</div>
	<br>
	<div class="col-md-6 col-sm-6 text-center">
		<h2>
			<c:out value="${brewery.name}" />
			Beers
		</h2>
		<div class="col-md-6 col-sm-6">
			<c:url var="addBeerUrl" value="/addBeer">
				<c:param name="breweryId" value="${brewery.breweryId}" />
			</c:url>
			<a href="${addBeerUrl}">
				<div class="brewery-tile">
					<i class="fa fa-plus fa-5x plus-beer" aria-hidden="true"></i>
				</div>
			</a>
		</div>
		<c:if test="${!beer.isEmpty()}">
			<c:forEach var="beer" items="${beers}">
				<div class="col-md-6 col-sm-6">
					<c:url var="beerDetailsUrl" value="/beerDetails">
						<c:param name="beerId" value="${beer.beerId}" />
					</c:url>
					<a href="${beerDetailsUrl}">
						<div class="brewery-tile text-center">
							<c:url var="imageUrl" value="/img/thumbnails/${beer.imgUrl}" />
							<img src="${imageUrl}" class="img-responsive"><br>
							<div>${beer.name}</div>
						</div>
					</a>
					<div>
						<c:url var="updateUrl" value="/updateBeer" />
						<form action="${updateUrl}" method="GET">
							<input type="hidden" name="beerId" value="${beer.beerId}"><input
								type="hidden" name="breweryId" value="${brewery.breweryId}"><input
								type="submit" value="UPDATE">
						</form>
						<c:url var="deleteUrl" value="/deleteBeer" />
						<form action="${deleteUrl}" method="POST">
							<input type="hidden" name="beerId" value="${beer.beerId}"><input
								type="hidden" name="breweryId" value="${brewery.breweryId}"><input
								type="submit" value="DELETE">
						</form>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
</div>

<%@ include file="common/footer.jspf"%>